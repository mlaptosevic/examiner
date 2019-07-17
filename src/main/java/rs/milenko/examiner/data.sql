insert into entity (id, name) values (1, 'student');
insert into entity (id, name) values (2, 'subject');
insert into entity (id, name) values (3, 'professor');

insert into attribute (id, name) values (1, 'name');
insert into attribute (id, name) values (2, 'index');
insert into attribute (id, name) values (3, 'name');
insert into attribute (id, name) values (4, 'years of experience');
insert into attribute (id, name) values (5, 'name');

insert into entity_attributes (entity_id, attributes_id) values (1,1);
insert into entity_attributes (entity_id, attributes_id) values (1,2);
insert into entity_attributes (entity_id, attributes_id) values (3,3);
insert into entity_attributes (entity_id, attributes_id) values (3,4);
insert into entity_attributes (entity_id, attributes_id) values (2,5);

insert into relationship (id, is_object, name) values (1, false, 'listening');
insert into relationship (id, is_object, name) values (2, false, 'teaching');

insert into entity_relationship_connection (id, cardinality, entity_id, relationship_id) values (1, 0, 1, 1);
insert into entity_relationship_connection (id, cardinality, entity_id, relationship_id) values (2, 0, 2, 1);
insert into entity_relationship_connection (id, cardinality, entity_id, relationship_id) values (3, 0, 2, 2);
insert into entity_relationship_connection (id, cardinality, entity_id, relationship_id) values (4, 0, 3, 2);

insert into ermodel (id) values (1);

insert into assignment (id, assignmentText, ermodel_id) values (1, 'TEST TEXT', 1);
