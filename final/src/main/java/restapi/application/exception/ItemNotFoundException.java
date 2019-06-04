package restapi.application.exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(long id) {
        super("Item is not found with id : " + id);
    }
}
