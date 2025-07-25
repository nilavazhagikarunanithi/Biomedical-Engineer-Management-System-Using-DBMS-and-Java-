package ui;
import dao.PatientDAO;
import dao.EquipmentDAO;
import models.Patient;
import models.Equipment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Biomedical Management System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton viewPatients = new JButton("View Patients");
        JButton addPatient = new JButton("Add Patient");
        JButton viewEquipment = new JButton("View Equipment");
        JButton addEquipment = new JButton("Add Equipment");

        add(viewPatients);
        add(addPatient);
        add(viewEquipment);
        add(addEquipment);

        addPatient.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
            String gender = JOptionPane.showInputDialog("Enter gender:");
            String diag = JOptionPane.showInputDialog("Enter diagnosis:");
            try {
                new PatientDAO().addPatient(new Patient(name, age, gender, diag));
                JOptionPane.showMessageDialog(this, "Patient added.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        viewPatients.addActionListener(e -> {
            try {
                List<Patient> list = new PatientDAO().getAllPatients();
                StringBuilder sb = new StringBuilder("Patients:\n");
                for (Patient p : list) {
                    sb.append(p.patientId + ": " + p.name + ", " + p.age + ", " + p.gender + ", " + p.diagnosis + "\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        addEquipment.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter equipment name:");
            String type = JOptionPane.showInputDialog("Enter type:");
            String status = JOptionPane.showInputDialog("Enter status:");
            try {
                new EquipmentDAO().addEquipment(new Equipment(name, type, status));
                JOptionPane.showMessageDialog(this, "Equipment added.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        viewEquipment.addActionListener(e -> {
            try {
                List<Equipment> list = new EquipmentDAO().getAllEquipment();
                StringBuilder sb = new StringBuilder("Equipment:\n");
                for (Equipment e1 : list) {
                    sb.append(e1.equipmentId + ": " + e1.name + ", " + e1.type + ", " + e1.status + "\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
