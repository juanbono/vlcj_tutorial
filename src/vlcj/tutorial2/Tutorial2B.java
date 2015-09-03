package vlcj.tutorial2;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
/*
 * http://www.capricasoftware.co.uk/projects/vlcj/tutorial2.html
 */
public class Tutorial2B {
 	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent2;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent3;
    public static void main(final String[] args) {
    	System.out.println("INICIALIZANDO...");
    	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files (x86)\\VideoLAN\\VLC" );
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tutorial2B(args);
            }
        });
    }
  
       	        
    private Tutorial2B(String[] args) {
  	      System.out.println("Creando ventana");
                              
          mediaPlayerComponent  = new EmbeddedMediaPlayerComponent();
          mediaPlayerComponent2 = new EmbeddedMediaPlayerComponent();
          mediaPlayerComponent3 = new EmbeddedMediaPlayerComponent();
                            
          JFrame frame  = new JFrame("vlcj Tutorial");
          frame.setLocation(100,100);
          frame.setSize(1024,780);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);

          JPanel content = new JPanel(new GridLayout(2, 0));
          content.add(mediaPlayerComponent2);
          content.add(mediaPlayerComponent3);

          frame.add(content);
          
          String ip = args[0];
      	  System.out.println("Agregando medio desde IP1: "+ip);
          mediaPlayerComponent2.getMediaPlayer().playMedia( ip );
          String ip2 = args[1];
       	  System.out.println("Agregando medio desde IP2: "+ip2);
          mediaPlayerComponent3.getMediaPlayer().playMedia( ip2 );

    }
};