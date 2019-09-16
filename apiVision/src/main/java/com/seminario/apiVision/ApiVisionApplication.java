package com.seminario.apiVision;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiVisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVisionApplication.class, args);

	}

}
