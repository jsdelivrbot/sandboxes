package demo;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;
import java.time.ZonedDateTime;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

	private static final long serialVersionUID = -797939782L;

	public static final QOrder order = new QOrder("order");

	public final StringPath createdByUser = createString("createdByUser");

	public final DateTimePath<ZonedDateTime> creationTime = createDateTime("creationTime", java.time.ZonedDateTime.class);

	public final StringPath description = createString("description");

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final DateTimePath<java.time.ZonedDateTime> modificationTime = createDateTime("modificationTime", java.time.ZonedDateTime.class);

	public final StringPath modifiedByUser = createString("modifiedByUser");

	public final StringPath title = createString("title");

	public final NumberPath<Long> version = createNumber("version", Long.class);

	public QOrder(String variable) {
		super(Order.class, forVariable(variable));
	}

	public QOrder(Path<Order> path) {
		super(path.getType(), path.getMetadata());
	}

	public QOrder(PathMetadata<?> metadata) {
		super(Order.class, metadata);
	}

}