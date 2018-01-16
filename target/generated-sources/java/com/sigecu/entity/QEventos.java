package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventos is a Querydsl query type for Eventos
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEventos extends EntityPathBase<Eventos> {

    private static final long serialVersionUID = 886560750L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventos eventos = new QEventos("eventos");

    public final SetPath<Alumno_Has_Eventos, QAlumno_Has_Eventos> alumnosHasEventos = this.<Alumno_Has_Eventos, QAlumno_Has_Eventos>createSet("alumnosHasEventos", Alumno_Has_Eventos.class, QAlumno_Has_Eventos.class, PathInits.DIRECT2);

    public final QCursos cursosEvento;

    public final StringPath eCapacidad = createString("eCapacidad");

    public final StringPath eDescripcion = createString("eDescripcion");

    public final StringPath eFechaInicio = createString("eFechaInicio");

    public final StringPath eFechaTermino = createString("eFechaTermino");

    public final StringPath eHorario = createString("eHorario");

    public final StringPath ePrograma = createString("ePrograma");

    public final StringPath eStatus = createString("eStatus");

    public final StringPath eTipo = createString("eTipo");

    public final NumberPath<Integer> idEvento = createNumber("idEvento", Integer.class);

    public final QInstructor instructor;

    public QEventos(String variable) {
        this(Eventos.class, forVariable(variable), INITS);
    }

    public QEventos(Path<? extends Eventos> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventos(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventos(PathMetadata metadata, PathInits inits) {
        this(Eventos.class, metadata, inits);
    }

    public QEventos(Class<? extends Eventos> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cursosEvento = inits.isInitialized("cursosEvento") ? new QCursos(forProperty("cursosEvento")) : null;
        this.instructor = inits.isInitialized("instructor") ? new QInstructor(forProperty("instructor"), inits.get("instructor")) : null;
    }

}

