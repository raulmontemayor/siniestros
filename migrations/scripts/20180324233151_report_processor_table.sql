--// report_processor table
CREATE TABLE report_processor_log (
        id NUMBER(12) PRIMARY KEY NOT NULL
        , external_id VARCHAR2(4000) NOT NULL
        , created_date TIMESTAMP NOT NULL 
        , json_data CLOB NULL,
        --CONSTRAINT ensure_data_json CHECK (json_data IS JSON),
        CONSTRAINT report_p_l_external_uq UNIQUE (external_id)
);


CREATE INDEX report_p_l_created_date_idx ON report_processor_log(created_date);

CREATE SEQUENCE report_processor_log_pk_seq  CACHE 10 ORDER;

/



--//@UNDO
-- SQL to undo the change goes here.


