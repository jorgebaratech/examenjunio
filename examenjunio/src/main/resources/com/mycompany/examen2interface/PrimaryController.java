/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.examen2interface;

import model.AlumnoDAOJDBC;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Alumno;
import model.AlumnoDAO;

/**
 * FXML Controller class
 *
 * @author norri
 */
public class PrimaryController implements Initializable {

    @FXML
    private TableView<Alumno> tablaAlumnos;
    @FXML
    private TableColumn<Alumno, String> nombrecolum;
    @FXML
    private TableColumn<Alumno, String> apellidocolum;
    @FXML
    private TableColumn<Alumno, String> adcolum;
    @FXML
    private TableColumn<Alumno, String> sgecolum;
    @FXML
    private TableColumn<Alumno, String> dicolum;
    @FXML
    private TableColumn<Alumno, String> pmdmcolum;
    @FXML
    private TableColumn<Alumno, String> pspcolum;
    @FXML
    private TableColumn<Alumno, String> eiecolum;
    @FXML
    private TableColumn<Alumno, String> hclcolum;
    @FXML
    private Button añadirnotas;
    @FXML
    private Button descargarnota;
    @FXML
    private Button salir;
    
    ObservableList<Alumno> listado;

    /**
     * Initializes the controller class.
     */
    
     private AlumnoDAO gestorAlumnos = new AlumnoDAOJDBC();
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidos;
    @FXML
    private Spinner<Integer> spAD;
    @FXML
    private Spinner<Integer> spSGE;
    @FXML
    private Spinner<Integer> spDI;
    @FXML
    private Spinner<Integer> spPMDM;
    @FXML
    private Spinner<Integer> spPSP;
    @FXML
    private Spinner<Integer> spEIE;
    @FXML
    private Spinner<Integer> spHLC;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listado = FXCollections.observableArrayList();

        // Alumnos añadidos a mano
        //listado.addAll(crearAlumnos());
        listado.addAll(traerAlumnosDeBaseDeDatos());

        tablaAlumnos.getItems().clear();
        tablaAlumnos.getItems().addAll(listado);

        nombrecolum.setCellValueFactory(new PropertyValueFactory("nombre"));
        apellidocolum.setCellValueFactory(new PropertyValueFactory("apellidos"));
        adcolum.setCellValueFactory(new PropertyValueFactory("ad"));
        sgecolum.setCellValueFactory(new PropertyValueFactory("sge"));
        dicolum.setCellValueFactory(new PropertyValueFactory("di"));
        pmdmcolum.setCellValueFactory(new PropertyValueFactory("pmdm"));
        pspcolum.setCellValueFactory(new PropertyValueFactory("psp"));
        eiecolum.setCellValueFactory(new PropertyValueFactory("eie"));
        hclcolum.setCellValueFactory(new PropertyValueFactory("hlc"));

        rellenarSpinners();
    }    
    
    private void btnAdd(ActionEvent event) {
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();
        Integer ad = spAD.getValue();
        Integer sge = spSGE.getValue();
        Integer di = spDI.getValue();
        Integer pmdm = spPMDM.getValue();
        Integer psp = spPSP.getValue();
        Integer eie = spEIE.getValue();
        Integer hlc = spHLC.getValue();

        Alumno alumno = new Alumno(4, nombre, apellidos, ad, sge, di, pmdm, psp, eie, hlc);
        tabla.getItems().add(alumno);
    }
    
@FXML
    private void btnSalir(ActionEvent event) {
        // FIN DE PROGRAMACIÓN EN CLASE
        System.exit(0);
    }    
    
    private ObservableList<Alumno> crearAlumnos() {
        ObservableList<Alumno> listado = FXCollections.observableArrayList(
                new Alumno(1, "Alumno", "Uno", 9, 9, 9, 9, 9, 9, 9),
                new Alumno(2, "Alumno", "Dos", 8, 8, 8, 8, 8, 8, 8),
                new Alumno(2, "Alumno", "Tres", 7, 7, 7, 7, 7, 7, 7));

        return listado;
    }
    
     private void rellenarSpinners() {
        SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spAD.setValueFactory(svf);

        SpinnerValueFactory svf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spSGE.setValueFactory(svf2);

        SpinnerValueFactory svf3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spDI.setValueFactory(svf3);

        SpinnerValueFactory svf4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spPMDM.setValueFactory(svf4);

        SpinnerValueFactory svf5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spPSP.setValueFactory(svf5);

        SpinnerValueFactory svf6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spEIE.setValueFactory(svf6);

        SpinnerValueFactory svf7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spHLC.setValueFactory(svf7);
    }
    
    
      @FXML
    private void clckModal(MouseEvent event) {
        Alumno alumno = tabla.getSelectionModel().getSelectedItem();
        Integer ad = alumno.getAd();
        Integer sge = alumno.getSge();
        Integer di = alumno.getDi();
        Integer pmdm = alumno.getPmdm();
        Integer psp = alumno.getPsp();
        Integer eie = alumno.getEie();
        Integer hlc = alumno.getHlc();

        Integer contador = 0;

        if (ad >= 5 && sge >= 5 && di >= 5 && pmdm >= 5 && psp >= 5 && eie >= 5 && hlc >= 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(alumno.getNombre() + " " + alumno.getApellidos());
            alert.setTitle("Notas medias");
            alert.setContentText("La nota media del alumno " + alumno.getNombre() + " " + alumno.getApellidos() + " es " + calculadoraDeMedias(alumno));
            alert.showAndWait();
        } else {

            if (ad < 5) {
                contador++;
            }

            if (sge < 5) {
                contador++;
            }

            if (di < 5) {
                contador++;
            }

            if (pmdm < 5) {
                contador++;
            }

            if (psp < 5) {
                contador++;
            }

            if (eie < 5) {
                contador++;
            }

            if (hlc < 5) {
                contador++;
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(alumno.getNombre() + " " + alumno.getApellidos());
            alert.setTitle("Asignaturas suspensas");
            alert.setContentText("El alumno " + alumno.getNombre() + " " + alumno.getApellidos() + " ha suspendido " + contador + " módulos.");
            alert.showAndWait();

        }

    }
    
    
    
    private Integer calculadoraDeMedias(Alumno alumno) {
        Integer ad = alumno.getAd();
        Integer sge = alumno.getSge();
        Integer di = alumno.getDi();
        Integer pmdm = alumno.getPmdm();
        Integer psp = alumno.getPsp();
        Integer eie = alumno.getEie();
        Integer hlc = alumno.getHlc();

        return (ad + sge + di + pmdm + psp + eie + hlc) / 7;
    }
    
    
    private ArrayList<Alumno> traerAlumnosDeBaseDeDatos() {
        return gestorAlumnos.getAlumnos();
    }
    
    
   
    
    
    
    
    
}
