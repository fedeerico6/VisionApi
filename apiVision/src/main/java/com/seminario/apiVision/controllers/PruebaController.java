package com.seminario.apiVision.controllers;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import com.google.protobuf.*;
import com.seminario.apiVision.models.ApiVisionRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @GetMapping
    public List<ApiVisionRequest> prueba(){
        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
            // The path to the image file to annotate
            String fileName = "C:\\Users\\Federico\\Documents\\esto.jpg";

            // Reads the image file into memory
            Path path = Paths.get(fileName);
            byte[] data = Files.readAllBytes(path);
            ByteString imgBytes = ByteString.copyFrom(data);

            // Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            Image img = Image.newBuilder().setContent(imgBytes).build();
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
                        ApiVisionRequest apiVisionRequest = new ApiVisionRequest(clave,v.toString());
                        respuesta.add(apiVisionRequest);
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
