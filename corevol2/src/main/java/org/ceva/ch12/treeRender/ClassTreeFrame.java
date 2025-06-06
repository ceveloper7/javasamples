package org.ceva.ch12.treeRender;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;

public class ClassTreeFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    private DefaultMutableTreeNode root;
    private DefaultTreeModel model;
    private JTree tree;
    private JTextField textField;
    private JTextArea textArea;

    public ClassTreeFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // the root of the class tree is Object
        root = new DefaultMutableTreeNode(java.lang.Object.class);
        model = new DefaultTreeModel(root);
        tree = new JTree(model);

        // add this class to populate the tree with some data
        addClass(getClass());

        // set up node icons. Personalizacion de los nodos.
        var renderer = new ClassNameTreeCellRenderer();
        renderer.setClosedIcon(new ImageIcon(this.getClass().getResource("/red-ball.gif")));
        renderer.setOpenIcon(new ImageIcon(this.getClass().getResource("/yellow-ball.gif")));
        renderer.setLeafIcon(new ImageIcon(this.getClass().getResource("/blue-ball.gif")));
        tree.setCellRenderer(renderer);

        // Find out current selection. set up selection mode.
        tree.addTreeSelectionListener(event ->
        {
            // the user selected a different node--update description
            TreePath path = tree.getSelectionPath();
            if (path == null) return;
            var selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            Class<?> c = (Class<?>) selectedNode.getUserObject();
            String description = getFieldDescription(c);
            textArea.setText(description);
        });
        // solo se permite la seleccion de un nodo
        int mode = TreeSelectionModel.SINGLE_TREE_SELECTION;
        tree.getSelectionModel().setSelectionMode(mode);

        // this text area holds the class description
        textArea = new JTextArea();

        // add tree and text area
        var panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(new JScrollPane(tree));
        panel.add(new JScrollPane(textArea));

        add(panel, BorderLayout.CENTER);

        addTextField();
    }

    /**
     * Add the text field and "Add" button to add a new class.
     */
    public void addTextField()
    {
        var panel = new JPanel();

        ActionListener addListener = event ->
        {
            // add the class whose name is in the text field
            try
            {
                String text = textField.getText();
                addClass(Class.forName(text)); // clear text field to indicate success
                textField.setText("");
            }
            catch (ClassNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, "Class not found");
            }
        };

        // new class names are typed into this text field
        textField = new JTextField(20);
        textField.addActionListener(addListener);
        panel.add(textField);

        var addButton = new JButton("Add");
        addButton.addActionListener(addListener);
        panel.add(addButton);

        add(panel, BorderLayout.SOUTH);
    }

    /**
     * Finds an object in the tree.
     * @param obj the object to find
     * @return the node containing the object or null if the object is not present in the tree
     */
    public DefaultMutableTreeNode findUserObject(Object obj)
    {
        // find the node containing a user object
        var e = (Enumeration<TreeNode>) root.breadthFirstEnumeration();
        while (e.hasMoreElements())
        {
            var node = (DefaultMutableTreeNode) e.nextElement();
            // verificamos si la clase existe en el Tree
            if (node.getUserObject().equals(obj)) return node;
        }
        return null;
    }

    /**
     * Adds a new class and any parent classes that aren't yet part of the tree.
     * @param c the class to add
     * @return the newly added node
     */
    public DefaultMutableTreeNode addClass(Class<?> c)
    {
        // add a new class to the tree

        // skip non-class types
        if (c.isInterface() || c.isPrimitive()) return null;

        // if the class is already in the tree, return its node
        DefaultMutableTreeNode node = findUserObject(c);
        if (node != null) return node;

        // class isn't present--first add class parent recursively

        Class<?> s = c.getSuperclass();

        DefaultMutableTreeNode parent;
        if (s == null) parent = root;
        else parent = addClass(s);

        // add the class as a child to the parent
        var newNode = new DefaultMutableTreeNode(c);
        model.insertNodeInto(newNode, parent, parent.getChildCount());

        // make node visible
        var path = new TreePath(model.getPathToRoot(newNode));
        tree.makeVisible(path);

        return newNode;
    }

    /**
     * Returns a description of the fields of a class.
     * @param c the class to be described
     * @return a string containing all field types and names
     */
    public static String getFieldDescription(Class<?> c)
    {
        // use reflection to find types and names of fields
        var r = new StringBuilder();
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            Field f = fields[i];
            if (Modifier.isStatic(f.getModifiers())) r.append("static ");
            r.append(f.getType().getName());
            r.append(" ");
            r.append(f.getName());
            r.append("\n");
        }
        return r.toString();
    }
}
