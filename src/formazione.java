/*
 * formazione.java
 *
 * Created on 17 dicembre 2004, 15.21
 */

/**
 *
 * @author Rgiuse
 */
import java.applet.Applet;
import java.awt.*;
public class formazione extends java.applet.Applet {
    
    private String[][] giocatoriSq=new String[2][11];
    private Image immagine;
    private int width;
    private int height;
    private int n_difSq1=4;
    private int n_centSq1=4;
    private int n_attSq1=2;
    private int n_difSq2=3;
    private int n_centSq2=5;
    private int n_attSq2=2;
    private FontMetrics fm;
    private Font mioFont=new Font("Arial", 1, 9);
    
    /** Initialization method that will be called after the applet is loaded
     *  into the browser.
     */
    public void init() {
        fm = getFontMetrics(mioFont);
        giocatoriSq[0][0]="";
        giocatoriSq[0][1]="";
        giocatoriSq[0][2]="";
        giocatoriSq[0][3]="";
        giocatoriSq[0][4]="";
        giocatoriSq[0][5]="";
        giocatoriSq[0][6]="";
        giocatoriSq[0][7]="";
        giocatoriSq[0][8]="";
        giocatoriSq[0][9]="";
        giocatoriSq[0][10]="";
        giocatoriSq[1][0]="";
        giocatoriSq[1][1]="";
        giocatoriSq[1][2]="";
        giocatoriSq[1][3]="";
        giocatoriSq[1][4]="";
        giocatoriSq[1][5]="";
        giocatoriSq[1][6]="";
        giocatoriSq[1][7]="";
        giocatoriSq[1][8]="";
        giocatoriSq[1][9]="";
        giocatoriSq[1][10]="";
        
        
        if (getParameter("n_attSq1")!=null && getParameter("n_centSq1")!=null &&getParameter("n_difSq1")!=null) {
            n_attSq1=Integer.parseInt(getParameter("n_attSq1"));
            n_difSq1=Integer.parseInt(getParameter("n_difSq1"));
            n_centSq1=Integer.parseInt(getParameter("n_centSq1"));
        }
        if (getParameter("n_attSq2")!=null && getParameter("n_centSq2")!=null &&getParameter("n_difSq2")!=null) {
            n_attSq2=Integer.parseInt(getParameter("n_attSq2"));
            n_difSq2=Integer.parseInt(getParameter("n_difSq2"));
            n_centSq2=Integer.parseInt(getParameter("n_centSq2"));
        }
        String s = getParameter("giocSq11");
        int jj=1;
        if(s != null && s!="") {jj=2;}
            for (int j=0;j<jj;j++) {
                for(int i = 1; i <= 11; i++) {
                    String gioc = getParameter("giocSq"+Integer.toString(j)+Integer.toString(i));
                    giocatoriSq[j][i-1] = gioc;
                }
            }
        
        immagine = getImage(getCodeBase(), "immagini/campo.gif");
        
        // TODO start asynchronous download of heavy resources
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;  // See note below
        g2.setFont(mioFont);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(immagine,0,0,size().width,size().height,this);
        Color oldc= g2.getColor();
        if(giocatoriSq[0][0] != null && giocatoriSq[0][0]!="")
        {
            g2.setColor(new Color(255,0,0));
            g2.fillOval(size().width/2-size().width/40,size().height/5*0+size().width/20,size().width/20,size().width/20);
            g2.drawString(giocatoriSq[0][0], size().width/2-(fm.stringWidth(giocatoriSq[0][0])/2), size().height/5*0+size().width/20);
            for (int i=1;i<=n_difSq1;i++){
                g2.drawString(giocatoriSq[0][i], size().width/(n_difSq1+1)*i-(fm.stringWidth(giocatoriSq[0][i])/2), size().height/5*1+size().width/20);
                g2.fillOval(size().width/(n_difSq1+1)*i-size().width/40,size().height/5*1+size().width/20,size().width/20,size().width/20);
            } 
            for (int i=1;i<=n_centSq1;i++){
                g2.drawString(giocatoriSq[0][n_difSq1+i], size().width/(n_centSq1+1)*i-(fm.stringWidth(giocatoriSq[0][n_difSq1+i])/2), size().height/5*2+size().width/35);
                g2.fillOval(size().width/(n_centSq1+1)*i-size().width/40,size().height/5*2+size().width/35,size().width/20,size().width/20);
            } 
            for (int i=1;i<=n_attSq1;i++){
                g2.drawString(giocatoriSq[0][n_difSq1+n_centSq1+i], size().width/(n_attSq1+1)*i-(fm.stringWidth(giocatoriSq[0][n_difSq1+n_centSq1+i])/2), size().height/5*3+size().width/20);
                g2.fillOval(size().width/(n_attSq1+1)*i-size().width/40,size().height/5*3+size().width/20,size().width/20,size().width/20);
            } 
        }
        if(giocatoriSq[1][0] != null && giocatoriSq[1][0]!="")
        {
            g2.setColor(new Color(0,0,255));
            g2.fillOval(size().width/2-size().width/40,size().height-size().width/10,size().width/20,size().width/20);
            g2.drawString(giocatoriSq[1][0], size().width/2-(fm.stringWidth(giocatoriSq[1][0])/2), size().height-size().width/10);
            for (int i=1;i<=n_difSq2;i++){
                g2.fillOval(this.size().width/(n_difSq2+1)*i-size().width/40,this.size().height-(size().height/5*1+size().width/10),size().width/20,size().width/20);
                g2.drawString(giocatoriSq[1][i], this.size().width/(n_difSq2+1)*i-(fm.stringWidth(giocatoriSq[1][i])/2), size().height-(size().height/5*1+size().width/10));
            } 
            for (int i=1;i<=n_centSq2;i++){
                g2.fillOval(this.size().width/(n_centSq2+1)*i-size().width/40,this.size().height-(size().height/5*2+size().width/15),size().width/20,size().width/20);
                g2.drawString(giocatoriSq[1][n_difSq2+i], this.size().width/(n_centSq2+1)*i-(fm.stringWidth(giocatoriSq[1][n_difSq2+i])/2), size().height-(size().height/5*2+size().width/15));
            } 
            for (int i=1;i<=n_attSq2;i++){
                g2.fillOval(this.size().width/(n_attSq2+1)*i-this.size().width/40,size().height-(size().height/5*3+size().width/10),size().width/20,size().width/20);
                g2.drawString(giocatoriSq[1][n_difSq2+n_centSq2+i], this.size().width/(n_attSq2+1)*i-(fm.stringWidth(giocatoriSq[1][n_difSq2+n_centSq2+i])/2), size().height-(size().height/5*3+size().width/10));
            }  
        } 
        g2.setColor(oldc);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
