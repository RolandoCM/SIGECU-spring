package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEvaluaciones is a Querydsl query type for Evaluaciones
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEvaluaciones extends EntityPathBase<Evaluaciones> {

    private static final long serialVersionUID = 635531883L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEvaluaciones evaluaciones = new QEvaluaciones("evaluaciones");

    public final QCursos cursos;

    public final StringPath eNombre = createString("eNombre");

    public final StringPath ePorsentaje = createString("ePorsentaje");

    public final StringPath eTiempo = createString("eTiempo");

    public final NumberPath<Integer> idEvaluacion = createNumber("idEvaluacion", Integer.class);

    public final SetPath<Preguntas, QPreguntas> preguntas = this.<Preguntas, QPreguntas>createSet("preguntas", Preguntas.class, QPreguntas.class, PathInits.DIRECT2);

    public QEvaluaciones(String variable) {
        this(Evaluaciones.class, forVariable(variable), INITS);
    }

    public QEvaluaciones(Path<? extends Evaluaciones> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEvaluaciones(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEvaluaciones(PathMetadata metadata, PathInits inits) {
        this(Evaluaciones.class, metadata, inits);
    }

    public QEvaluaciones(Class<? extends Evaluaciones> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cursos = inits.isInitialized("cursos") ? new QCursos(forProperty("cursos")) : null;
    }

}

