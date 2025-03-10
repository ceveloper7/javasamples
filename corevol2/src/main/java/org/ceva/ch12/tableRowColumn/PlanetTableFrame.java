package org.ceva.ch12.tableRowColumn;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

/**
 * This frame contains a table of planet data.
 */
public class PlanetTableFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 500;

    public static final int COLOR_COLUMN = 4;
    public static final int IMAGE_COLUMN = 5;

    private JTable table;
    private HashSet<Integer> removedRowIndices;
    private ArrayList<TableColumn> removedColumns;
    private JCheckBoxMenuItem rowsItem;
    private JCheckBoxMenuItem columnsItem;
    private JCheckBoxMenuItem cellsItem;

    private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous", "Color", "Image" };

    private Object[][] cells = {
            { "Mercury", 2440.0, 0, false, Color.YELLOW,
                    new ImageIcon(this.getClass().getResource("/Mercury.gif")) },
            { "Venus", 6052.0, 0, false, Color.YELLOW,
                    new ImageIcon(this.getClass().getResource("/Venus.gif")) },
            { "Earth", 6378.0, 1, false, Color.BLUE,
                    new ImageIcon(this.getClass().getResource("/Earth.gif")) },
            { "Mars", 3397.0, 2, false, Color.RED,
                    new ImageIcon(this.getClass().getResource("/Mars.gif")) },
            { "Jupiter", 71492.0, 16, true, Color.ORANGE,
                    new ImageIcon(this.getClass().getResource("/Jupiter.gif")) },
            { "Saturn", 60268.0, 18, true, Color.ORANGE,
                    new ImageIcon(this.getClass().getResource("/Saturn.gif")) },
            { "Uranus", 25559.0, 17, true, Color.BLUE,
                    new ImageIcon(this.getClass().getResource("/Uranus.gif")) },
            { "Neptune", 24766.0, 8, true, Color.BLUE,
                    new ImageIcon(this.getClass().getResource("/Neptune.gif")) },
            { "Pluto", 1137.0, 1, false, Color.BLACK,
                    new ImageIcon(this.getClass().getResource("/Pluto.gif")) } };

    public PlanetTableFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        var model = new DefaultTableModel(cells, columnNames)
        {
            // get column type class
            public Class<?> getColumnClass(int c)
            {
                return cells[0][c].getClass();
            }
        };

        table = new JTable(model);

        // resizing columns
        table.setRowHeight(100);
        table.getColumnModel().getColumn(COLOR_COLUMN).setMinWidth(250);
        table.getColumnModel().getColumn(IMAGE_COLUMN).setMinWidth(100);

        // manejando el ordenamiento
        var sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        /*
         * Aplicamos un custom comparator. Cuando se hace click en la columna Color
         * vemos que los planetas blue se van al final
         */
        sorter.setComparator(COLOR_COLUMN, Comparator.comparing(Color::getBlue)
                .thenComparing(Color::getGreen).thenComparing(Color::getRed));

        // la columna que contiene las imagenes no permitimos el ordenamiento.
        sorter.setSortable(IMAGE_COLUMN, false);
        add(new JScrollPane(table), BorderLayout.CENTER);

        removedRowIndices = new HashSet<>();
        removedColumns = new ArrayList<>();

        // aplicando custom Filter para remover filas
        var filter = new RowFilter<TableModel, Integer>()
        {
            public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry)
            {
                return !removedRowIndices.contains(entry.getIdentifier());
            }
        };

        // create menu
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var selectionMenu = new JMenu("Selection");
        menuBar.add(selectionMenu);

        rowsItem = new JCheckBoxMenuItem("Rows");
        columnsItem = new JCheckBoxMenuItem("Columns");
        cellsItem = new JCheckBoxMenuItem("Cells");

        rowsItem.setSelected(table.getRowSelectionAllowed());
        columnsItem.setSelected(table.getColumnSelectionAllowed());
        cellsItem.setSelected(table.getCellSelectionEnabled());

        rowsItem.addActionListener(event ->
        {
            table.clearSelection();
            // Permitimos la seleccion de filas
            table.setRowSelectionAllowed(rowsItem.isSelected());
            updateCheckboxMenuItems();
        });
        selectionMenu.add(rowsItem);

        columnsItem.addActionListener(event ->
        {
            table.clearSelection();
            // permitimos la seleccion de columnas
            table.setColumnSelectionAllowed(columnsItem.isSelected());
            updateCheckboxMenuItems();
        });
        selectionMenu.add(columnsItem);

        cellsItem.addActionListener(event ->
        {
            table.clearSelection();
            // permitimos la seleccion de celda (seleccion de fila y columna)
            table.setCellSelectionEnabled(cellsItem.isSelected());
            updateCheckboxMenuItems();
        });
        selectionMenu.add(cellsItem);

        var tableMenu = new JMenu("Edit");
        menuBar.add(tableMenu);

        var hideColumnsItem = new JMenuItem("Hide Columns");
        hideColumnsItem.addActionListener(event ->
        {
            int[] selected = table.getSelectedColumns();
            TableColumnModel columnModel = table.getColumnModel();

            // remove columns from view, starting at the last
            // index so that column numbers aren't affected

            for (int i = selected.length - 1; i >= 0; i--)
            {
                TableColumn column = columnModel.getColumn(selected[i]);
                table.removeColumn(column); // remove a column from table view but not from table model

                // store removed columns for "show columns" command

                removedColumns.add(column);
            }
        });
        tableMenu.add(hideColumnsItem);

        var showColumnsItem = new JMenuItem("Show Columns");
        showColumnsItem.addActionListener(event ->
        {
            // restore all removed columns
            for (TableColumn tc : removedColumns)
                table.addColumn(tc);
            removedColumns.clear();
        });
        tableMenu.add(showColumnsItem);

        var hideRowsItem = new JMenuItem("Hide Rows");
        hideRowsItem.addActionListener(event ->
        {
            int[] selected = table.getSelectedRows();
            for (int i : selected)
                removedRowIndices.add(table.convertRowIndexToModel(i));
            sorter.setRowFilter(filter); // APPLY FILTER
        });
        tableMenu.add(hideRowsItem);

        var showRowsItem = new JMenuItem("Show Rows");
        showRowsItem.addActionListener(event ->
        {
            removedRowIndices.clear();
            sorter.setRowFilter(filter);
        });
        tableMenu.add(showRowsItem);

        var printSelectionItem = new JMenuItem("Print Selection");
        printSelectionItem.addActionListener(event ->
        {
            int[] selected = table.getSelectedRows();
            System.out.println("Selected rows: " + Arrays.toString(selected));
            selected = table.getSelectedColumns();
            System.out.println("Selected columns: " + Arrays.toString(selected));
        });
        tableMenu.add(printSelectionItem);
    }

    private void updateCheckboxMenuItems()
    {
        rowsItem.setSelected(table.getRowSelectionAllowed());
        columnsItem.setSelected(table.getColumnSelectionAllowed());
        cellsItem.setSelected(table.getCellSelectionEnabled());
    }
}
