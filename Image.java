import java.util.*;

/**
 * Image
 */
public class Image {
    String id;
    Set<String> tags;
    char type; // H or V. 2 Vs form an H with combined id

    public Image() {
    }

    public Image(String id, Set<String> tags, char type) {
        this.id = id;
        this.tags = new HashSet<String>();
        this.type = type;
    }

    public Image(String id, String line) {
        this.id = id;
        String[] d = line.split(" ");
        this.type = d[0].charAt(0);
        this.tags = new HashSet<String>();
        for (int i = 0; i < Integer.parseInt(d[1]); i++) {
            this.tags.add(d[i+2]);
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getTags() {
        return this.tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public char getType() {
        return this.type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Image id(String id) {
        this.id = id;
        return this;
    }

    public Image tags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public Image type(char type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Image)) {
            return false;
        }
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(tags, image.tags) && type == image.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tags, type);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", tags='" + getTags() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
    
}