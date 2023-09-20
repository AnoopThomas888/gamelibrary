package org.wecancodeit.gamelibrary.Models;



import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_boardgame")
public class BoardGameModel {
    

    @Id
    @GeneratedValue
    private long id;
     
    @Nonnull
     @Size(max=100,min=5)
     @Column(name = "GameName",length=100,unique=true)
    private String name;
    

    @Nonnull
    @Size(max=500)
    @Column(length=500)
    private String description;
     
    @Nonnull
    @Size(max=500)
    @Column(length=500)
    private String imageurl;
    
    @ManyToOne
    private PublisherModel publisher;
    
    public BoardGameModel() {
    }
    public BoardGameModel(@Size(max = 100, min = 5) String name, @Size(max = 500) String description,
            @Size(max = 500) String imageurl, PublisherModel publisher) {
        this.name = name;
        this.description = description;
        this.imageurl = imageurl;
        this.publisher = publisher;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImageurl() {
        return imageurl;
    }
    public PublisherModel getPublisher() {
        return publisher;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BoardGameModel other = (BoardGameModel) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "BoardGame [id=" + id + ", name=" + name + "]";
    }


}
