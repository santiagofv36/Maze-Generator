package Laberinto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class view extends JFrame{
    

    private JTextField x = new JTextField();
    private JTextField y = new JTextField();
    private JButton generar = new JButton("Generar");
    private JButton resolver = new JButton("Resolver");
    private JLabel label = new JLabel("Ingrese la dimension del laberinto");
    private boolean flag = false;
    private JLabel dimension = new JLabel("Dimension: m x n");


    public view(){
        super("Laberinto");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        add(x);
        add(generar);
        add(resolver);
        x.setBounds(50, 50, 50, 30);
        generar.setBounds(50, 100, 100, 30);
        resolver.setBounds(50, 150, 100, 30);
        add(label);
        label.setBounds(50, 200, 200, 30);
        y.setBounds(120, 50, 50, 30);
        add(y);
        add(dimension);
        dimension.setBounds(50, 20, 100, 30);
        

        //paint a circle when generar is pressed

        generar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                flag = true;
                repaint();
            }
        });
    }

    public Casilla[][] generar(){
        int m = Integer.parseInt(x.getText());
        int n = Integer.parseInt(y.getText());
        Casilla[][] laberinto = new Casilla[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                laberinto[i][j] = new Casilla();
                laberinto[i][j].setPosicion(i, j);
                // Si es un borde entonces es pared
                if(i == 0 || i == m-1 || j == 0 || j == n-1){
                    laberinto[i][j].setPared(true);
                }
                else{
                    laberinto[i][j].setPared(true);
                }
                if(i == 1 && j == 1){
                    laberinto[i][j].setInicio(true);
                }

                if(i == m-2 && j == n-2){
                    laberinto[i][j].setFin(true);
                }


            }
        }
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                laberinto[i][j].addVecinos(laberinto);
            }
        }
         return laberinto;
        
    }



    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(flag){
            Casilla[][] casillas = generar();
            int dimX = casillas.length;
            int dimY = casillas[0].length;
            int x = 0;
            int y = 0;
            for (int i = 0; i < dimX; i++) {
                for (int j = 0; j < dimY; j++) {
                    if (casillas[i][j].isPared()){
                        g.setColor(Color.BLACK);
                        g.fillRect(x+270, y+100, dimX*dimY /3, dimX*dimY/3);
                    }else{
                        g.setColor(Color.WHITE);
                        g.fillRect(x+270, y+100, dimX*dimY /3, dimX*dimY/3);
                    }
                    if (casillas[i][j].isInicio()){
                        g.setColor(Color.GREEN);
                        g.fillRect(x+270, y+100, dimX*dimY /3, dimX*dimY/3);
                    }
                    if (casillas[i][j].isFin()){
                        g.setColor(Color.RED);
                        g.fillRect(x+270, y+100, dimX*dimY /3, dimX*dimY/3);
                    }
                    if (casillas[i][j].isVisitado()){
                        g.setColor(Color.BLUE);
                        g.fillRect(x+270, y+100, dimX*dimY /3, dimX*dimY/3);
                    }
                    x += 50;
                }
                x = 0;
                y += 50;
            }
            flag = false;
        }
    }




    public static void main(String[] args) {

        view v = new view();
        
    }

}
