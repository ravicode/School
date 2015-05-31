import java.io.IOException;
import javax.swing.*;
import java.awt.*;

public class JLabelLink extends JFrame {

private static final long serialVersionUID = 1L;

public JLabelLink() {
super() ;
JLabel a;
setTitle( "Click on the JLabel to start the webpage." ) ;
setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

JPanel pane = new JPanel();
setContentPane(pane);
setLayout(new FlowLayout());

JLabel label= new JLabel( " http://www.duccsystems.com/cricket " , JLabel.CENTER );
label.setOpaque(true);
label.setBackground(Color.RED);
getContentPane().add(label) ;

label.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
if(evt.getClickCount() > 0){
try {
Process pc = Runtime.getRuntime().exec("cmd.exe /c start http://www.duccsystems.com/cricket");
} catch (IOException ex) {
System.out.println(ex.getMessage());
System.out.println();
}
}
}
});
setSize( 400 , 100 );
setVisible( true );
}

public static void main(String[] args) {
new JLabelLink () ;
}
}