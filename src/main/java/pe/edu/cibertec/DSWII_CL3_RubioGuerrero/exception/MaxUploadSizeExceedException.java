package pe.edu.cibertec.DSWII_CL3_RubioGuerrero.exception;

public class MaxUploadSizeExceedException extends RuntimeException {
    public MaxUploadSizeExceedException (String message){
        super(message);
    }
}
