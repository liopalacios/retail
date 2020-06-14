package com.intercorp.api.retail.service.impl;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;

@Service
public class FBInitialize {
    @PostConstruct
    public void initialize () {
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type","service_account");
            jsonObject.put("project_id","retail-939a8");
            jsonObject.put("private_key_id","1c1796b4f5858cf69ae08eedab66143ebf37e6c1");
            jsonObject.put("private_key","-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVZWqW/oQvtkd+\nAQmPxdeIeEpMQC98lOjacAdoDt8a1AIyAbXwa9fP8Np1WH42QMdhObNy6SytRkqQ\n8JofpnfOGDjETMspXpu8CvdCiqD7hI5aLchPgokw6ThRfQq04bsHnSC4BVaeUobt\nY2xgrNx9J9eYZsWj4n4TrXI41qFViog1q/T45OdPGgGHNacDaJz20+GmeoEhgfL5\n8DYAi/4PnLq4MENEtR5xy9+OKJgIg7QUAXng9kDiLOeolfqnQBUtlgQ3HwmtFqq1\n5IfBceboWjyk7ukN+qkxTWAxBklGao49/YDTP0Hv4TN2OgDkQi1Q+FWJATQh9JDq\nBiRcWRQxAgMBAAECggEARRdrDTvWHE67j42hQ2mm/UlMaylADOi9K9ClzD0cd0bX\nYRMjdnYZj+R+08hCTor06oUJ9bna3KPmdlOfo8WUIK9ZCYfOaWqEsZmMsqx0OP4b\n657CxerD0ef6EM24duDyY1oKuLBXV88o8X6Kr8ciDYuwjJ3zB5EG58jOS3UPlgRP\nJxvBRFeoL32CqW0A8pnR8RSzL4T28dUeBOg8icesAToTFTOnIp4AxRZ78YX6hOm8\nWFNjzaMecPrHVYShcRgsVVRrzPqPvO9dhtIssZUG2HSMyVE5n1fQd/0gkBj0cO/P\nXyTaIBDKuZiBOm5XoIYtDedMsDI7P8ZL0DXpVO1eRQKBgQDQrXX1gTiZ6MAnjIpN\nkHDlCe2OmSBa7IP6leMcLZeQ9WYZxp4chV2h/hiFG6ChwybpBPdy83RPRp3/CiO6\n47iy4t9HeJIuABnFWBKp8jcWIQPkmXrXkZUCEnDbDRzzDXro0EVPj1aHXKzqVLjO\nLc0P44TDAgrHaXeklEjjUFR60wKBgQC3RnCpulczd+NdcEDsI9PTTQFREL8Nv4UY\nlGEC7zBp8+iZTCBVibB/sdAUO6FtZiP7IFbpuFjVtWTK5veB29Lh08h041KQWwYU\n6Mo1r+4TtA8084qt/eJZAIaMcchF9tDqc9MGMI0A3LX0junoJkwNa8sA+/QW+TDV\naEOwmVyKawKBgF2u4hwbrTt7gHjA4X488FIDCQFRwXLQZ9fh3pnR5g+P/AxqXKVV\nQlntZziq1IyKvjcyoZybq4XDoD7VYIEQpuS4caD2gjnglbFA/vAI664lmEfSl5Gb\nrBfIC55r3qlHTfyjM9qp8SDH/GEfM/BsI3mUnQ+nJQutT6c1YxuZ/rM9AoGBAI5j\n3sIvMPKe0XnV7crJJxjCeiRmU1k2FAz9ssVZ2g5nXq5DU9fBKux61IPztD5PneLM\nxFm/TN10mcN+YIt2o0eqh9IwjwPyhC4YkonVjq2mNi5YjMUTPBkT7HUPLZ8V3Ehb\nBneHnvUthPxlUFt57Zp7xfOUzJZQsl0LLZP2AszTAoGAS4e47oP2+J2tGumSHpOX\nhQmz3llS3Ws/Q5J1gyPMjOzE/TfBwYjIbBxRVErxYRCk/985SvWikEZ5IbQeTHrT\nFVxmpfq0sqa5d2K0Yw/QqRcWdv3fffv5pE6Op45OpD8EDiozPevDEY2N+N+dRG+z\nUvVPlbS/YEYh9bv4q1rBP/A=\n-----END PRIVATE KEY-----\n");
            jsonObject.put("client_email","firebase-adminsdk-s2zax@retail-939a8.iam.gserviceaccount.com");
            jsonObject.put("client_id","113251964446685925459");
            jsonObject.put("auth_uri","https://accounts.google.com/o/oauth2/auth");
            jsonObject.put("token_uri","https://oauth2.googleapis.com/token");
            jsonObject.put("auth_provider_x509_cert_url","https://www.googleapis.com/oauth2/v1/certs");
            jsonObject.put("client_x509_cert_url","https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-s2zax%40retail-939a8.iam.gserviceaccount.com");
            System.out.println(" INICIO LECTURA DE ARCHIVO JSON ======================>");
            /*FileInputStream serviceAccount =
                    new FileInputStream("serviceaccount.json");*/
            System.out.println("LECTURA DE ARCHIVO JSON ======================>");
            String s = jsonObject.toString();
            InputStream stream1 = new ByteArrayInputStream(s.getBytes());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(stream1))
                    .setDatabaseUrl("https://retail-939a8.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }
}
