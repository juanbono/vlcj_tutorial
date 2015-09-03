package vlcj.tutorial2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;


import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.ibm.media.bean.multiplayer.ImageButton;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
/*
 * http://www.capricasoftware.co.uk/projects/vlcj/tutorial2.html
 */
public class Prueba {

    public static void main(final String[] args) {
    	System.out.println("INICIALIZANDO...");
    	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files (x86)\\VideoLAN\\VLC" );
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prueba(args);
            }
        });
    }
        	        
	private Prueba(String[] args) {
		System.out.println("Creando ventana");

		JFrame frame  = new JFrame("vlcj Tutorial");
		frame.setLocation(100,100);
		frame.setSize(1024,780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel content = new JPanel(new GridLayout(2, 0));
		
		List<EmbeddedMediaPlayerComponent> mediaPlayers = new ArrayList<EmbeddedMediaPlayerComponent>();
  		///Texto Botones
/*		@Override 
		public void onPause() {
			   super.onPause();
			   if (mediaPlayer != null & !pause) {
			       mediaPlayer.pause();
			   }
			}
			@Override public void onResume() {
			   super.onResume();
			   if (mediaPlayer != null & !pause) {
			       mediaPlayer.start();
			   }
			}
*/		//___________________________________________________
		//Botones
		   
		//JButton jb1=new JButton();  
		//JButton jb2 =new JButton();   
	              
		// jb1.setBounds(10, 10, 200, 200); 
		//jb2.setBounds(240, 10, 400, 250);
	    	          
		//jb1.addActionListener((ActionListener) this);
		//jb2.addActionListener((ActionListener) this);
	            
		//jb1= new JButton("Play"); jb2= new JButton("Stop"); //añadiendo objetos al jpanel
		 
	//_____________

		frame.add(content);
		for(String ip : args){
			
			EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
			content.add(mediaPlayerComponent);
			mediaPlayerComponent.getMediaPlayer().playMedia( ip );
			content.add(new JLabel("Medio desde IP: "+ip));
			//content.add(jb1, BorderLayout.NORTH);
			//content.add(jb2, BorderLayout.WEST);
			
		}
	}
  };