package com.project.iosephknecht.barcode_view.data.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DocumentInfo {
    @Id
    private long id;

    private String description;

    @Generated(hash = 583535859)
    public DocumentInfo(long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Generated(hash = 978182962)
    public DocumentInfo() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
