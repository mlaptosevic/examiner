insert ermodel (id) values (1);

insert into assignment (id, title, assignment_text, correct_answer_id) values (1, 'Manufacturer', 'A manufacturing company produces products. The following product information is stored: product name, product ID and quantity on hand. These products are made up of many components. Each component can be supplied by one or more suppliers. The following component information is kept: component ID, name, description, suppliers who supply them, and products in which they are used.', 1);

insert entity (id, name, er_model_id) VALUES (1, 'Component', 1);

insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('CompId', true, false, 1);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('CompName', false, false, 1);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('Description', false, false, 1);

insert entity (id, name, er_model_id) VALUES (2, 'Component Support', 1);

insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('CompId', true, true, 2);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('SuppId', true, true, 2);

insert entity (id, name, er_model_id) VALUES (3, 'Supplier', 1);

insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('SuppId', true, false, 3);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('SuppName', false, false, 3);

insert entity (id, name, er_model_id) VALUES (4, 'Build', 1);

insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('CompId', true, true, 4);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('CompName', true, true, 4);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('QtyOfComp', false, false, 4);

insert entity (id, name, er_model_id) VALUES (5, 'Product', 1);

insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('ProdId', true, false, 1);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('ProdName', false, false, 1);
insert attribute (name, is_primary_key, is_foreign_key, entity_id) VALUES ('QtyOnHand', false, false, 1);

insert relationship (id, er_model_id) VALUES (1, 1);

insert relationship_edge (entity_id, relationship_id) VALUES (1, 1);
insert relationship_edge (entity_id, relationship_id) VALUES (2, 1);

insert relationship (id, er_model_id) VALUES (2, 1);

insert relationship_edge (entity_id, relationship_id) VALUES (2, 2);
insert relationship_edge (entity_id, relationship_id) VALUES (3, 2);

insert relationship (id, er_model_id) VALUES (3, 1);

insert relationship_edge (entity_id, relationship_id) VALUES (1, 3);
insert relationship_edge ( entity_id, relationship_id) VALUES (4, 3);

insert relationship (id, er_model_id) VALUES (4, 1);

insert relationship_edge (entity_id, relationship_id) VALUES (4, 4);
insert relationship_edge ( entity_id, relationship_id) VALUES (5, 4);

insert ermodel (id) values (2);

insert into assignment (id, title, assignment_text, correct_answer_id) values (2, 'Car Dealership', 'A salesperson may sell many cars, but each car is sold by only one salesperson.
A customer may buy many cars, but each car is bought by only one customer.
A salesperson writes a single invoice for each car he or she sells.
A customer gets an invoice for each car he or she buys.
A customer may come in just to have his or her car serviced; that is, a customer need not buy a car to be classified as a customer.
When a customer takes one or more cars in for repair or service, one service ticket is written for each car.
The car dealership maintains a service history for each of the cars serviced. The service  records are referenced by the car’s serial number.
A car brought in for service can be worked on by many mechanics, and each mechanic may work on many cars.
A car that is serviced may or may not need parts (e.g., adjusting a carburetor or cleaning a fuel injector nozzle does not require providing new parts).', 1);

insert entity (id, name, er_model_id) VALUES (6, 'Salesperson', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Saleperson_ID', 6);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Last Name', 6);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'First Name', 6);

insert entity (id, name, er_model_id) VALUES (7, 'Sales Invoce', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Invoice_ID', 7);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Invoice Number', 7);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Date', 7);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Car ID', 7);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Customer ID', 7);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Salesperson ID', 7);

insert entity (id, name, er_model_id) VALUES (8, 'Car', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Car_ID', 8);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Serial Number', 8);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Make', 8);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Model', 8);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Colour', 8);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Year', 8);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Car for Sale Y/N', 8);

insert entity (id, name, er_model_id) VALUES (9, 'Customer', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Customer_ID', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Last Name', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'First Name', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Phone Number', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Address', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'City', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'State/Province', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Country', 9);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Postal Code', 9);

insert entity (id, name, er_model_id) VALUES (10, 'Mechanic', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Mechanic_ID', 10);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Last Name', 10);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'First Name', 10);

insert entity (id, name, er_model_id) VALUES (11, 'Service Ticket', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Service_Ticket_ID', 11);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Service Ticket Number', 11);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Card ID', 11);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Customer ID', 11);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Data Received', 11);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Comments', 11);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Data Returned to Customer', 11);

insert entity (id, name, er_model_id) VALUES (12, 'Service', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Service_ID', 12);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Service Name', 12);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Hourly Rate', 12);

insert entity (id, name, er_model_id) VALUES (13, 'Service Mechanic', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Service_Mechanic_ID', 13);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Service Ticket ID', 13);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Service ID', 13);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Mechanic ID', 13);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Hours', 13);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Comment', 13);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Rate', 13);

insert entity (id, name, er_model_id) VALUES (14, 'Parts Used', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Parts_Used_ID', 14);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Part ID', 14);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, true, 'Service Ticket ID', 14);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Number Used', 14);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Price', 14);

insert entity (id, name, er_model_id) VALUES (15, 'Parts', 2);

insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (true, false, 'Parts_ID', 15);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Part Number', 15);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Description', 15);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Purchase Price', 15);
insert attribute (is_primary_key, is_foreign_key, name, entity_id) VALUES (false, false, 'Retail Price', 15);

insert relationship (id, er_model_id) VALUES (5, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (6, 5);
insert relationship_edge (entity_id, relationship_id) VALUES (7, 5);

insert relationship (id, er_model_id) VALUES (6, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (7, 6);
insert relationship_edge (entity_id, relationship_id) VALUES (8, 6);

insert relationship (id, er_model_id) VALUES (7, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (7, 7);
insert relationship_edge (entity_id, relationship_id) VALUES (9, 7);

insert relationship (id, er_model_id) VALUES (8, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (8, 8);
insert relationship_edge (entity_id, relationship_id) VALUES (11, 8);

insert relationship (id, er_model_id) VALUES (9, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (9, 9);
insert relationship_edge (entity_id, relationship_id) VALUES (11, 9);

insert relationship (id, er_model_id) VALUES (10, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (13, 10);
insert relationship_edge (entity_id, relationship_id) VALUES (11, 10);

insert relationship (id, er_model_id) VALUES (11, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (14, 11);
insert relationship_edge (entity_id, relationship_id) VALUES (11, 11);

insert relationship (id, er_model_id) VALUES (12, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (13, 12);
insert relationship_edge (entity_id, relationship_id) VALUES (10, 12);

insert relationship (id, er_model_id) VALUES (13, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (13, 13);
insert relationship_edge (entity_id, relationship_id) VALUES (12, 13);

insert relationship (id, er_model_id) VALUES (14, 2);

insert relationship_edge (entity_id, relationship_id) VALUES (14, 14);
insert relationship_edge (entity_id, relationship_id) VALUES (15, 14);
