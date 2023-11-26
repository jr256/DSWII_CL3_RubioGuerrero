package pe.edu.cibertec.DSWII_CL3_RubioGuerrero.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {
    private final Path imagesFolder = Paths.get("Images");
    private final Path documentosFolder = Paths.get("Documentos");
    private final long MAX_FILE_SIZE_BYTES = 1_500_000;

    public void guardarImagen(MultipartFile archivo) throws IOException {
        if (!archivo.getOriginalFilename().toLowerCase().endsWith(".png")) {
            throw new IllegalArgumentException("La extensión del archivo debe ser PNG");
        }

        Path filePath = imagesFolder.resolve(archivo.getOriginalFilename());
        guardarArchivo(archivo, filePath);
    }

    public void guardarExcel(MultipartFile archivo) throws IOException {
        if (!archivo.getOriginalFilename().toLowerCase().endsWith(".xlsx")) {
            throw new IllegalArgumentException("La extensión del archivo debe ser XLSX");
        }

        if (archivo.getSize() > MAX_FILE_SIZE_BYTES) {
            throw new IllegalArgumentException("El archivo excede el tamaño máximo permitido (1.5MB)");
        }

        Path filePath = documentosFolder.resolve(archivo.getOriginalFilename());
        guardarArchivo(archivo, filePath);
    }

    private void guardarArchivo(MultipartFile archivo, Path filePath) throws IOException {
        Files.copy(archivo.getInputStream(), filePath);
    }



}
