package com.seminario.apiVision.services;

import com.google.cloud.vision.v1.*;
import com.seminario.apiVision.models.ApiVisionRequest;
import com.seminario.apiVision.models.Url;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST})
public class ApiVisionService {

    public List<ApiVisionRequest> apiVisionRequests(Url url) {
        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
            // The path to the image file to annotate
            String fileName = url.getName();


            // Reads the image file into memory
            /*Path path = Paths.get(fileName);
            byte[] data = Files.readAllBytes(path);
            ByteString imgBytes = ByteString.copyFrom(data);*/

            // Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            //Image img = Image.newBuilder().setContent(imgBytes).build();
            Image img = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(fileName).build()).build();
            Feature feat = Feature.newBuilder().setType(Feature.Type.LABEL_DETECTION).build();
            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                    .addFeatures(feat)
                    .setImage(img)
                    .build();
            requests.add(request);

            // Performs label detection on the image file
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            List<ApiVisionRequest> respuesta = new ArrayList<>();
            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.printf("Error: %s\n", res.getError().getMessage());
                    return null;
                }
                for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
                    annotation.getAllFields().forEach((k, v) -> {
                        String clave = k.toString();
                        String[] claves = clave.split("\\.");
                        clave = claves[claves.length-1];
                        respuesta.add(new ApiVisionRequest(clave,v.toString()));
                    });
                }
            }
            return respuesta;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
