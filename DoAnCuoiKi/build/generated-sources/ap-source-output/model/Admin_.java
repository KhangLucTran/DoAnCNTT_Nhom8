package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-29T19:28:36", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SingularAttribute<Admin, String> password;
    public static volatile SingularAttribute<Admin, Long> adminID;
    public static volatile SingularAttribute<Admin, String> email;

}