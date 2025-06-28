-- Demo data for table "appointment"
INSERT INTO appointment
  (full_name, email_address, phone_number,
   appointment_date, appointment_time,
   description,               created_at,           updated_at)
VALUES
  ('Gouri Shanker', 'gouri@example.com',  '919876543210',
   '2025-06-20',     '10:30:00',
   'Initial speech‑therapy consultation.',
   NOW(),            NOW()),

  ('Priya Patel',   'priya.patel@gmail.com', '919812345678',
   '2025-06-21',     '14:00:00',
   'Follow‑up appointment to review progress.',
   NOW(),            NOW()),

  ('Rohan Mehta',   'rohan.m@example.org',   '919900112233',
   '2025-06-22',     '09:15:00',
   'First‑time assessment for hearing aid fitting.',
   NOW(),            NOW()),

  ('Sarah Johnson', 'sarah.j@outlook.com',   '919955667788',
   '2025-06-23',     '11:45:00',
   'Routine check‑up and device calibration.',
   NOW(),            NOW()),

  ('Aman Verma',    'aman.verma@yahoo.com',  '919988776655',
   '2025-06-24',     '16:30:00',
   'Counselling session with parents and child.',
   NOW(),            NOW());
