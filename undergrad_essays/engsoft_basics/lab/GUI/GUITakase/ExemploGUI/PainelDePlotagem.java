/*
 * Created on 16/03/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author fktakase
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.awt.*;


public class PainelDePlotagem extends Panel{

	  /** dimensão da área de visualização */
	  protected Dimension d;
	  /** cor utilizada na plotagem */
	  protected Color cor = Color.black;
	  /** Posição da origem do sistema de coordenadas */
	  protected int xorigem, yorigem;
	  /** número de pixels por unidade de escala na direção x */
	  protected int xpixporunidade = 20;
	  /** número de pixels por unidade de escala na direção y */
	  protected int ypixporunidade = 20;

	  protected static int MAX_FUNCOES = 10;
	  protected int numeroDeFuncoes = 0;
	  protected Funcao funcoes[] = new Funcao[MAX_FUNCOES];
	  protected Color cores[] = new Color[MAX_FUNCOES];



	  public PainelDePlotagem(){

	  }
	  public void paint(Graphics g) {
	    desenhaCoordenadas(g);
	    plotaFuncao(g);
	  }

	  //
	  // Método para plotagem das funções cadastradas
	  protected void plotaFuncao(Graphics g) {
	    for (int i = 0; i < numeroDeFuncoes; i++) {
	       if (funcoes[i] != null) {
	         Color c = cores[i];
	         if (c != null)
	           g.setColor(c);
	         else
	           g.setColor(Color.black);
	           for (int px = 0; px < d.width; px++) {
	              try {
	                double x = (double) (px - xorigem) / (double) xpixporunidade;
	                double y = funcoes[i].f(x);
	                int py = yorigem - (int) (y * ypixporunidade);
	                g.fillOval(px - 1, py - 1, 3, 3);
	              } catch (Exception  e) {}
	           }
	       }
	    }
	  }

	  //
	  // Método para adicionar novas funcoes para plotagem.
	  // recebe como parâmetro um objeto da classe função e a cor
	  // que deve ser utilizada em sua plotagem
	  final public void adicionaFuncao(Funcao f, Color c) {
	    if (numeroDeFuncoes < MAX_FUNCOES && f  !=  null) {
	      funcoes[numeroDeFuncoes] = f;
	      cores[numeroDeFuncoes++] = c;
	    }
	   repaint();
	  }

	  protected void desenhaCoordenadas(Graphics g) {
	  	//	  dimensões da área de visualização da Applet
	  	d = getSize();
	    // coordenada x da origem
	    xorigem = d.width / 2;
	    // coordenada y da origem
	    yorigem = d.height / 2;

	    g.setColor(Color.white);
	    g.fillRect(0, 0, d.width, d.height);

	    g.setColor(cor);
	    g.drawLine(0, yorigem, d.width, yorigem);
	    g.drawLine(xorigem, 0, xorigem, d.height);

	    g.setFont(new Font("Arial", Font.PLAIN, 10));
	    int px, py;
	    int i = 1;
	    py = yorigem + 12;
	    g.drawString("0", xorigem + 2, py);
	    for (px = xorigem + xpixporunidade; px < d.width; px += xpixporunidade) {
	      g.drawString(Integer.toString(i++), px - 2, py);
	      g.drawLine(px, yorigem - 2, px, yorigem + 2);
	    }

	    i = -1;
	    for (px = xorigem - xpixporunidade; px >= 0; px -= xpixporunidade) {
	      g.drawString(Integer.toString(i--), px - 2, py);
	      g.drawLine(px, yorigem - 2, px, yorigem + 2);
	    }

	    i = 1;
	    px = xorigem + 4;
	    for (py = yorigem - ypixporunidade; py >= 0; py -= ypixporunidade) {
	      g.drawString(Integer.toString(i++), px, py + 4);
	      g.drawLine(xorigem - 2, py, xorigem + 2, py);
	    }

	    i = -1;
	    for (py = yorigem + ypixporunidade; py < d.height; py += ypixporunidade) {
	      g.drawString(Integer.toString(i--), px, py + 4);
	      g.drawLine(xorigem - 2, py, xorigem + 2, py);
	    }
	  }

}
