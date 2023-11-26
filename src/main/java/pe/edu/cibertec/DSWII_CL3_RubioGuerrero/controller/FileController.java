package pe.edu.cibertec.DSWII_CL3_RubioGuerrero.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.DSWII_CL3_RubioGuerrero.model.response.ResponseFile;
import pe.edu.cibertec.DSWII_CL3_RubioGuerrero.service.FileService;

import java.io.IOException;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/file")
@CrossOrigin(origins = "https://www.cibertec.edu.pe")
public class FileController {

    private FileService fileService;
    @PostMapping("/filesimages")
    public ResponseEntity<String> subirImagen(@RequestParam("file") MultipartFile archivo) {
        try {
            fileService.guardarImagen(archivo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Imagen subida exitosamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir imagen: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/filesexcel")
    public ResponseEntity<String> subirExcel(@RequestParam("file") MultipartFile archivo) {
        try {
            fileService.guardarExcel(archivo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Excel subido exitosamente");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir archivo Excel: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
