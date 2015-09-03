package vlcj.tutorial2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
/*
 * http://www.capricasoftware.co.uk/projects/vlcj/tutorial2.html
 */
public class Consola {

    public static void main(final String[] args) {
    	System.out.println("INICIALIZANDO...");
    	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files (x86)\\VideoLAN\\VLC" );
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consola(args);
            }
        });
    }
      	        
	private Consola(String[] args) {
		System.out.println("Creando ventana");

		JFrame frame  = new JFrame("vlcj Tutorial");
		frame.setLocation(100,100);
		frame.setSize(1024,780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel content = new JPanel(new GridLayout(2, 0));

		List<EmbeddedMediaPlayerComponent> mediaPlayers = new ArrayList<EmbeddedMediaPlayerComponent>();
  
		frame.add(content);
	
		for(String ip : args){
			EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
			content.add(mediaPlayerComponent);
			mediaPlayerComponent.getMediaPlayer().playMedia( ip );
			content.add(new JLabel("Agregando medio desde IP: "+ip));
		}
    }
};
