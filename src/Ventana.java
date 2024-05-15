import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ventana {
    private JPanel Ventana;
    private JTextField textCedula;
    private JTextField textNombre;
    private JTextField textEdad;
    private JComboBox cBoxGenero;
    private JComboBox cBoxRegion;
    private JButton añadirButton;
    private JList list1;
    private JButton buscarGeneroEdadButton;
    private JButton buscarEdadRegionButton;
    private JList list2;

    private Cola personas = new Cola();
    DefaultListModel dlm = new DefaultListModel<>();
    DefaultListModel dlm1 = new DefaultListModel<>();

    public Ventana() {

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    personas.encolar(textCedula.getText(), textNombre.getText(), Integer.parseInt(textEdad.getText()),
                            cBoxGenero.getSelectedItem().toString(), cBoxRegion.getSelectedItem().toString());
                    List<PersonaRualesGuillermo> lista = personas.listarPersonas();
                    llenarJlist(lista, list1, dlm);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                setearCampos();
            }
        });

        buscarGeneroEdadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<PersonaRualesGuillermo> listaEdadSexo = personas.listaEdadSexo(Integer.parseInt(textEdad.getText()),
                            cBoxGenero.getSelectedItem().toString());
                    if (listaEdadSexo.isEmpty())
                        JOptionPane.showMessageDialog(null, "Busqueda no Coincide");
                    else
                        llenarJlist(listaEdadSexo, list2, dlm1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        buscarEdadRegionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<PersonaRualesGuillermo> listaEdadRegion = personas.listaEdadRegion(Integer.parseInt(textEdad.getText()),
                            cBoxGenero.getSelectedItem().toString());
                    if (listaEdadRegion.isEmpty())
                        JOptionPane.showMessageDialog(null, "Busqueda no Coincide");
                    else
                        llenarJlist(listaEdadRegion, list2, dlm1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void setearCampos(){
        textCedula.setText("");
        textNombre.setText("");
        textEdad.setText("");
        cBoxGenero.setSelectedIndex(0);
        cBoxRegion.setSelectedIndex(0);
    }

    public void llenarJlist(List <PersonaRualesGuillermo> lista, JList listaMostrar, DefaultListModel dl){
        dl.removeAllElements();
        Collections.sort(lista);
        for (PersonaRualesGuillermo p: lista)
            dl.addElement(p);
        listaMostrar.setModel(dl);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
