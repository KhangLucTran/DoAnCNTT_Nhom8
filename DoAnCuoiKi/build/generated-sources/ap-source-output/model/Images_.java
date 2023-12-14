package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Tour;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-29T19:28:36", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Images.class)
public class Images_ { 

    public static volatile SingularAttribute<Images, String> titleImage;
    public static volatile SingularAttribute<Images, String> linkImage;
    public static volatile SingularAttribute<Images, Long> id;
    public static volatile SingularAttribute<Images, Tour> tour;

}