
package co.com.appexplorer.util.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feed {

    private Author author;
    private List<Entry> entry = null;
    private Updated updated;
    private Rights_ rights;
    private Title_ title;
    private Icon icon;
    private List<Link_> link = null;
    private Id_ id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    public Updated getUpdated() {
        return updated;
    }

    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    public Rights_ getRights() {
        return rights;
    }

    public void setRights(Rights_ rights) {
        this.rights = rights;
    }

    public Title_ getTitle() {
        return title;
    }

    public void setTitle(Title_ title) {
        this.title = title;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public List<Link_> getLink() {
        return link;
    }

    public void setLink(List<Link_> link) {
        this.link = link;
    }

    public Id_ getId() {
        return id;
    }

    public void setId(Id_ id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
