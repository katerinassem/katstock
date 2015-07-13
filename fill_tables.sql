INSERT INTO katstock.address(
            address_id, country, region, street, building, description)
    VALUES (1, 'Belarus', 'Minsk', 'Tulskaya', '20a', NULL);
    
INSERT INTO katstock.stock_organization(
            stock_organization_id, title, address_id)
    VALUES (1, 'CoolStock', 1);

INSERT INTO katstock.role(
            role_id, role_name)
    VALUES (1, 'ADMIN');

INSERT INTO katstock."user"(
            user_id, enabled, user_name, surname, email, user_password, role_id, 
            stock_organization_id)
    VALUES (1, FALSE, 'Jack', 'Colp', 'jack@jack.com', '8cb2237d0679ca88db6464eac60da96345513964', 1, 
            1);
            
INSERT INTO katstock.address(
            address_id, country, region, street, building, description)
    VALUES (2, 'Lala', 'Lala', 'Lala', '23', NULL);
    
INSERT INTO katstock.address(
            address_id, country, region, street, building, description)
    VALUES (3, 'Russia', 'Moskow', 'Central', '3', NULL);
    
INSERT INTO katstock.address(
            address_id, country, region, street, building, description)
    VALUES (4, 'USA', 'New York', 'Hide St.', '678b', NULL);

INSERT INTO katstock.stock(
            stock_id, stock_name, description, square, cost_per_kg_per_day, 
            photo_url, address_id, stock_organization_id)
    VALUES (1, 'CoolStock', 'Very popular Lala stock', 1000, 0.3, 
            NULL, 2, 1);

INSERT INTO katstock.stock(
            stock_id, stock_name, description, square, cost_per_kg_per_day, 
            photo_url, address_id, stock_organization_id)
    VALUES (2, 'StocKing', 'Amazing stock with refrigerators', 5000, 1, 
            NULL, 3, 1);
            
INSERT INTO katstock.stock(
            stock_id, stock_name, description, square, cost_per_kg_per_day, 
            photo_url, address_id, stock_organization_id)
    VALUES (3, 'Hidest inc. stock', 'At the Hide Str.', 3000, 3, 
            NULL, 4, 1);
