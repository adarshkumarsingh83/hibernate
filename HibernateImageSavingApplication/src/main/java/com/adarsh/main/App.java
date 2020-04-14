package com.adarsh.main;

import com.adarsh.domain.Avatar;
import com.adarsh.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Hibernate save image into database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        //save image into database
        File file = new File("c:\\sourcen.jpg");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Avatar avatar = new Avatar();
        avatar.setImage(bFile);
        session.save(avatar);
        transaction.commit();



        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction1 = session.beginTransaction();
        //Get image from database
        Avatar avatar2 = (Avatar) session1.get(Avatar.class, avatar.getAvatarId());
        byte[] bAvatar = avatar2.getImage();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("e:\\sourcen.jpg");
            fileOutputStream.write(bAvatar);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        transaction1.commit();
        logger.info("execution completed");
    }
}
