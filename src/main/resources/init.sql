insert into coordinate
    (coordinate_id, created_at, updated_at, name, tel)
values
    (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '코디1', '01021457894'),
    (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '코디2', '01034239677'),
    (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '코디3', '01046728899');

insert into customer
    (customer_id, created_at, updated_at, address1, address2, name, tel, coordinate_id)
values
    (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 34', '377동 804호', '고객1', '01061987243', 1),
    (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 43', '345동 1301호', '고객2','01085632332', 2),
    (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 광정로 25-20', '356동 604호', '고객3','01062135412', 3),
    (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 16', '323동 501호', '고객4','01038765674', 1),
    (5, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 43', '338동 102호', '고객5','01078126423', 2),
    (6, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 광정로 25-20', '360동 801호', '고객6','01057835674', 3),
    (7, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 34', '379동 902호', '고객7','01049897674', 1),
    (8, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 43', '344동 805호', '고객8','01050937038', 2),
    (9, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 광정로 25-20', '360동 303호', '고객9','01021776571', 3),
    (10, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 34', '377동 401호', '고객10','01088119922', 1),
    (11, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 43', '337동 1006호', '고객11','01025691213', 2),
    (12, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 광정로 25-20', '357동 1001호', '고객12','01082736458', 3),
    (13, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 16', '326동 204호', '고객13','01051262778', 1),
    (14, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 오금로 43', '335동 702호', '고객14','01055363115', 2),
    (15, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '경기도 군포시 광정로 25-20', '361동 502호', '고객15','01057447465', 3);

insert into product
    (product_id, created_at, updated_at, type)
values
    (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER'),
    (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'BIDET'),
    (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'MATTRESS'),
    (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'AIR_CLEANER');

insert into have_product
    (have_product_id, created_at, updated_at, customer_id, product_id)
values
    (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 1),
    (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 2),
    (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 3),
    (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 4),
    (5, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 1),
    (6, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 2),
    (7, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 3),
    (8, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 3, 2),
    (9, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 3, 3),
    (10, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  3, 4),
    (11, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  4, 1),
    (12, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  4, 2),
    (13, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  4, 4),
    (14, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  5, 1),
    (15, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  5, 2),
    (16, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  6, 1),
    (17, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  6, 3),
    (18, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  7, 1),
    (19, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  7, 4),
    (20, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  8, 2),
    (21, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  8, 3),
    (22, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  9, 2),
    (23, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  9, 4),
    (24, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  10, 3),
    (25, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  10, 4),
    (26, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  11, 1),
    (27, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  12, 2),
    (28, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  13, 3),
    (29, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  14, 4),
    (30, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281',  15, 1);

insert into schedule
    (schedule_id, created_at, updated_at, date_time, status, coordinate_id, have_product_id)
values
    (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 14:30:00', 'END', 1, 1),
    (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 15:00:00', 'END', 1, 2),
    (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 15:30:00', 'END', 1, 3),
    (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 16:00:00', 'END', 1, 4),
    (5, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-18 15:00:00', 'END', 1, 11),
    (6, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 15:30:00', 'END', 1, 12),
    (7, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 16:00:00', 'END', 1, 13);


-- insert into matching_coordinate
--     (matching_coordinate_id, created_at, updated_at, coordinate_id, have_product_id)
-- values
--     (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 1, 1),
--     (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 2, 1),
--     (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 3, 3, 1),
--     (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 1, 2),
--     (5, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 2, 2),
--     (6, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 3, 3, 2),
--     (7, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 7),
--     (8, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 8),
--     (9, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 3, 9),
--     (10, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 10),
--     (11, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 11),
--     (12, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 3, 12),
--     (13, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 1, 13),
--     (14, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 2, 14),
--     (15, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 3, 15);

--
-- insert into schedule
-- (schedule_id, created_at, updated_at, date_time, status, coordinate_id, have_product_id)
-- values
--     (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 14:30:00', 'END', 1, 1),
--     (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-16 14:30:00', 'VERIFIED', 2, 5),
--     (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-17 10:00:00', 'SEND_REQUEST', 3, 3),
--     (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-18 11:30:00', 'SEND_REQUEST', 1, 4),
--     (5, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-18 13:00:00', 'SEND_REQUEST', 2, 5),
--     (6, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-18 13:00:00', 'SEND_REQUEST', 3, 1),
--     (7, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-19 11:00:00', 'SEND_REQUEST', 1, 2),
--     (8, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-20 14:30:00', 'SEND_REQUEST', 2, 3),
--     (9, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-20 15:30:00', 'SEND_REQUEST', 3, 4),
--     (10, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-20 16:00:00', 'SEND_REQUEST', 1, 5);

-- insert into product
--     (product_id, created_at, updated_at, type, coordinate_id, customer_id)
-- values
--     (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 1, 1),
--     (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'BIDET', 1, 1),
--     (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'MATTRESS', 1, 1),
--     (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'AIR_CLEANER', 1, 1),
--     (5, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 2, 2),
--     (6, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'BIDET', 2, 2),
--     (7, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'BIDET', 3, 3),
--     (8, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'MATTRESS', 3, 3),
--     (9, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'AIR_CLEANER', 1, 4),
--     (10, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'MATTRESS', 2, 5),
--     (11, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'AIR_CLEANER', 3, 6),
--     (12, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 1, 7),
--     (13, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 2, 8),
--     (14, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 3, 9),
--     (15, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 1, 10),
--     (16, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'BIDET', 2, 11),
--     (17, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'MATTRESS', 2, 11),
--     (18, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'AIR_CLEANER', 2, 11),
--     (19, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 3, 12),
--     (20, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 1, 13),
--     (21, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 2, 14),
--     (22, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'BIDET', 2, 14),
--     (23, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'MATTRESS', 2, 14),
--     (24, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', 'WATER_PURIFIER', 3, 15);

-- insert into schedule
--     (schedule_id, created_at, updated_at, date_time, status, coordinate_id, customer_id, product_id)
-- values
--     (1, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-12 14:30:00', 'END', 1, 1, 1),
--     (2, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-16 14:30:00', 'VERIFIED', 2, 2, 5),
--     (3, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-17 10:00:00', 'SEND_REQUEST', 3, 3, 7),
--     (4, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-18 11:30:00', 'SEND_REQUEST', 1, 4, 9),
--     (5, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-18 13:00:00', 'SEND_REQUEST', 2, 5, 10),
--     (6, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-18 13:00:00', 'SEND_REQUEST', 3, 6, 11),
--     (7, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-19 11:00:00', 'SEND_REQUEST', 1, 7, 12),
--     (8, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-20 14:30:00', 'SEND_REQUEST', 2, 8, 13),
--     (9, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-20 15:30:00', 'SEND_REQUEST', 3, 9, 14),
--     (10, '2022-01-07T15:23:16.281', '2022-01-07T15:23:16.281', '2022-11-20 16:00:00', 'SEND_REQUEST', 3, 15, 24);
