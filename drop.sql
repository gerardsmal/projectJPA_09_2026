
    alter table abbonamento_socio 
       drop 
       foreign key FK22uaw7830fw71duo88vg10i3m;

    alter table socio_palestra 
       drop 
       foreign key FK6vuimd1p9npmb28l93wouo0rn;

    drop table if exists abbonamento_socio;

    drop table if exists `certificato medico`;

    drop table if exists socio_palestra;
