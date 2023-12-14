package model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Description;
import model.Images;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-29T19:28:36", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile ListAttribute<Tour, Images> images;
    public static volatile SingularAttribute<Tour, String> accommodations;
    public static volatile SingularAttribute<Tour, Date> dateStart;
    public static volatile SingularAttribute<Tour, String> idTour;
    public static volatile SingularAttribute<Tour, Double> price;
    public static volatile ListAttribute<Tour, Description> description;
    public static volatile SingularAttribute<Tour, Integer> idCongty;
    public static volatile SingularAttribute<Tour, String> linkGGmap;
    public static volatile SingularAttribute<Tour, Date> dateEnd;
    public static volatile SingularAttribute<Tour, String> tourName;
    public static volatile SingularAttribute<Tour, String> transportation;

}