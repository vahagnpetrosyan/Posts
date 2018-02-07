package posts.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostForm {

    @NotNull
    @Size(min = 1, max = 150)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostForm postForm = (PostForm) o;

        return message.equals(postForm.message);
    }

    @Override
    public int hashCode() {
        return message.hashCode();
    }
}
