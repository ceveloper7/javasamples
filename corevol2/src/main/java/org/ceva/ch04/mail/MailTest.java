package org.ceva.ch04.mail;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.mail.internet.MimeMessage.RecipientType;

public class MailTest {
    public static void main(String[] args) throws MessagingException, IOException
    {
        var props = new Properties();
        try (Reader in = Files.newBufferedReader(
                Path.of("mail", "mail.properties")))
        {
            props.load(in);
        }
        List<String> lines = Files.readAllLines(Path.of(args[0]));

        String from = lines.get(0);
        String to = lines.get(1);
        String subject = lines.get(2);

        var builder = new StringBuilder();
        for (int i = 3; i < lines.size(); i++)
        {
            builder.append(lines.get(i));
            builder.append("\n");
        }

        Console console = System.console();
        var password = new String(console.readPassword("Password: "));

        Session mailSession = Session.getDefaultInstance(props);
        // mailSession.setDebug(true);
        var message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(builder.toString());
        Transport tr = mailSession.getTransport();
        try
        {
            tr.connect(null, password);
            tr.sendMessage(message, message.getAllRecipients());
        }
        finally
        {
            tr.close();
        }
    }
}
