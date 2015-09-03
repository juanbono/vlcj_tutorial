package vlcj.tutorial1;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

/*
 * http://www.capricasoftware.co.uk/projects/vlcj/tutorial1.html
 */
public class Tutorial1A {

    public static void main(String[] args) {
    	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files (x86)\\VideoLAN\\VLC\\lib" );
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }
}