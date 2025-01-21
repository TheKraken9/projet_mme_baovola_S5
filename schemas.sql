create database voyage;
drop database voyage;

create table bouquet(
    id_bouquet serial primary key ,
    bouquet varchar(50) not null,
    prix_bouquet double precision default 0
);
drop table bouquet cascade ;
insert into bouquet(bouquet) values('VIP');
insert into bouquet(bouquet) values('Standard');
insert into bouquet(bouquet) values('Economique');
select * from bouquet;
create table lieu(
    id_lieu serial primary key ,
    lieu varchar(50) not null,
    prix_lieu double precision default 0
);
drop table lieu cascade ;
insert into lieu(lieu) values('Regional');
insert into lieu(lieu) values('National');
insert into lieu(lieu) values('International');


create table activite(
    id_activite serial primary key ,
    activite varchar(50) not null
);
drop table activite cascade ;
insert into activite(activite) values('Plonge');
insert into activite(activite) values('Ski');
insert into activite(activite) values('Randonnee');
insert into activite(activite) values('Plonge');
insert into activite(activite) values('Parapente');
insert into activite(activite) values('Velo');
insert into activite(activite) values('Plonge');

select activite.id as id, activite.nom as activite, b.nom as bouquet, b.id_bouquet as id_bouquet from activite join bouquet b on b.id_bouquet = activite.id_bouquet;
select activite_par_bouquet.id_activite_par_bouquet as id, activite_par_bouquet.duree as duree, a.activite as activite, b.bouquet as bouquet, b.id_bouquet from activite_par_bouquet join activite a on activite_par_bouquet.id_activite = a.id_activite join bouquet b on b.id_bouquet = activite_par_bouquet.id_bouquet where b.id_bouquet = 1;
select * from activite join bouquet b on b.id_bouquet = activite.id_bouquet;
select * from bouquet;

create table activite_par_bouquet(
    id_activite_par_bouquet serial primary key ,
    id_activite int references activite(id_activite),
    id_bouquet int references bouquet(id_bouquet),
    duree double precision not null,
    prix_activite double precision default 0
);
drop table activite_par_bouquet cascade ;

create table voyage(
    id_voyage serial primary key ,
    date_debut timestamp not null ,
    date_fin timestamp not null ,
    id_lieu int references lieu(id_lieu),ea
    id_bouquet int references bouquet(id_bouquet),
    nom varchar(250) not null,
    cin varchar(50) default '',
    contact varchar(50) default '',
    prix_voyage double precision default 0
);
drop table voyage cascade ;

create table activite_pdt_voyage(
    id_act serial primary key ,
    id_voyage int references voyage(id_voyage),
    id_activite int references activite_par_bouquet(id_activite_par_bouquet)
);
drop table activite_pdt_voyage cascade ;

select * from activite_pdt_voyage;
select * from activite_par_bouquet;
select * from voyage;
insert into voyage(date_debut, date_fin, id_lieu, id_bouquet) values('2019-01-01 00:00:00', '2019-01-01 00:00:00', 1, 1) returning id_voyage;
