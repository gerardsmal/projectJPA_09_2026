
    create table `certificato medico` (
        data_certificato date,
        id integer not null auto_increment,
        tipo_certificato bit,
        primary key (id)
    ) engine=InnoDB;

    create table socio_palestra (
        certificato_id integer,
        id integer not null auto_increment,
        codice_fiscale varchar(16) not null,
        cognome varchar(100) not null,
        nome varchar(100) not null,
        email varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table socio_palestra 
       add constraint UKc50sxuty0tgtsra75twkb7o1v unique (certificato_id);

    alter table socio_palestra 
       add constraint UKkomp5csel946vm6jyxq537rae unique (codice_fiscale);

    alter table socio_palestra 
       add constraint FK6vuimd1p9npmb28l93wouo0rn 
       foreign key (certificato_id) 
       references `certificato medico` (id);
