package com.project.iosephknecht.barcode_view.data.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class DocumentModel {
    @Id
    private long id;
    private Long documentInfoId;

    private String codeText;
    private byte[] modelArray;

    @ToOne(joinProperty = "documentInfoId")
    private DocumentInfo documentInfo;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 976668023)
    private transient DocumentModelDao myDao;

    @Generated(hash = 135601836)
    public DocumentModel(long id, Long documentInfoId, String codeText,
            byte[] modelArray) {
        this.id = id;
        this.documentInfoId = documentInfoId;
        this.codeText = codeText;
        this.modelArray = modelArray;
    }

    @Generated(hash = 2006783301)
    public DocumentModel() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getDocumentInfoId() {
        return this.documentInfoId;
    }

    public void setDocumentInfoId(Long documentInfoId) {
        this.documentInfoId = documentInfoId;
    }

    public String getCodeText() {
        return this.codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }

    public byte[] getModelArray() {
        return this.modelArray;
    }

    public void setModelArray(byte[] modelArray) {
        this.modelArray = modelArray;
    }

    @Generated(hash = 791841682)
    private transient Long documentInfo__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 133497268)
    public DocumentInfo getDocumentInfo() {
        Long __key = this.documentInfoId;
        if (documentInfo__resolvedKey == null
                || !documentInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DocumentInfoDao targetDao = daoSession.getDocumentInfoDao();
            DocumentInfo documentInfoNew = targetDao.load(__key);
            synchronized (this) {
                documentInfo = documentInfoNew;
                documentInfo__resolvedKey = __key;
            }
        }
        return documentInfo;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 171757170)
    public void setDocumentInfo(DocumentInfo documentInfo) {
        synchronized (this) {
            this.documentInfo = documentInfo;
            documentInfoId = documentInfo == null ? null : documentInfo.getId();
            documentInfo__resolvedKey = documentInfoId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1259165055)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDocumentModelDao() : null;
    }
}
