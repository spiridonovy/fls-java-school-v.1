package app.exception;

public class NoEntityException extends Exception {

    private Long id;

    public NoEntityException(Long id){
        super("Could not find this entity " + id);
        this.id = id;
    }
}
