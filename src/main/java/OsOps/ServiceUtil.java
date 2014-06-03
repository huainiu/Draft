package OsOps;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Michael on 5/25/2014.
 */


public class ServiceUtil {

    interface MyAdvapi32 extends StdCallLibrary {
        public MyAdvapi32 INSTANCE = (MyAdvapi32) Native.loadLibrary("Advapi32", MyAdvapi32.class, W32APIOptions.UNICODE_OPTIONS);

        public boolean QueryServiceConfig(
                Winsvc.SC_HANDLE hService,
                QUERY_SERVICE_CONFIG lpServiceConfig,
                int cbBufSize,
                IntByReference pcbBytesNeeded
        );
    }

    public static class QUERY_SERVICE_CONFIG extends Structure {
        public WinDef.DWORD dwServiceType;
        public WinDef.DWORD dwStartType;
        public WinDef.DWORD dwErrorControl;
        public char[] lpBinaryPathName;
        public char[] lpLoadOrderGroup;
        public WinDef.DWORD dwTagId;
        public char[] lpDependencies;
        public char[] lpServiceStartName;
        public char[] lpDisplayName;

        public QUERY_SERVICE_CONFIG() {
        }

        public QUERY_SERVICE_CONFIG(int size) {
            lpBinaryPathName = new char[256];
            lpLoadOrderGroup = new char[256];
            lpDependencies = new char[256];
            lpServiceStartName = new char[256];
            lpDisplayName = new char[256];
            allocateMemory(size);
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("lpBinaryPathName", "lpLoadOrderGroup", "lpDependencies", "lpServiceStartName", "lpDisplayName");
        }
    }

    public static QUERY_SERVICE_CONFIG queryServiceConfig(W32Service service) {
        IntByReference size = new IntByReference();
        MyAdvapi32.INSTANCE.QueryServiceConfig(
                service.getHandle(),
                null,
                0,
                size
        );
        QUERY_SERVICE_CONFIG config = new QUERY_SERVICE_CONFIG(size.getValue());
        if (!MyAdvapi32.INSTANCE.QueryServiceConfig(
                service.getHandle(),
                config,
                config.size(),
                size
        )) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return config;
    }


    public static String checkService(String serviceToCheck) {
        W32ServiceManager serviceManager = new W32ServiceManager();
        serviceManager.open(Winsvc.SC_MANAGER_ALL_ACCESS);
        W32Service service = serviceManager.openService(serviceToCheck, Winsvc.SC_MANAGER_ALL_ACCESS);

        IntByReference size = new IntByReference();
        MyAdvapi32.INSTANCE.QueryServiceConfig(
                service.getHandle(),
                null,
                0,
                size
        );


        QUERY_SERVICE_CONFIG config = queryServiceConfig(service);
        String result = config.dwStartType.toString();
        service.close();
        return result;

    }


    public static void main(String[] args) {
        W32ServiceManager serviceManager = new W32ServiceManager();
        W32Service service = serviceManager.openService("SDScannerService", Winsvc.SC_MANAGER_ALL_ACCESS);
        ServiceUtil.queryServiceConfig(service);
    }

}