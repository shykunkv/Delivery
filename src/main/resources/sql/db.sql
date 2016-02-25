CREATE TABLE "public"."addresses" (
    "address_id" serial DEFAULT nextval(''::regclass),
    "address_building" text NOT NULL,
    "address_street" text NOT NULL,
    "address_city" text NOT NULL,
    PRIMARY KEY ("address_id")
) TABLESPACE "pg_default";


