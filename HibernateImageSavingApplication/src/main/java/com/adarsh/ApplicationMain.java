package com.adarsh;

import com.adarsh.entity.Avatar;
import com.adarsh.persistence.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Slf4j
public class ApplicationMain {


    public static void main(String[] args) {
        log.info("Hibernate save image into database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        //save image into database
        File file = new File("image/source-dir/image.jpg");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            log.error("{}", e.getMessage());
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
            FileOutputStream fileOutputStream = new FileOutputStream("image/destination-dir/image" + System.currentTimeMillis() + ".jpg");
            fileOutputStream.write(bAvatar);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        transaction1.commit();
        log.info("execution completed");
    }
}
