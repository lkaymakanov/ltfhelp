
--column comments for tables in public
SELECT
    cols.table_name,
    cols.column_name,
    (
        SELECT
            pg_catalog.col_description(c.oid, cols.ordinal_position::int)
        FROM
            pg_catalog.pg_class c
        WHERE
            c.oid = (SELECT ('"' || cols.table_name || '"')::regclass::oid)
            AND c.relname = cols.table_name
    ) AS column_comment
FROM
    information_schema.columns cols
WHERE
cols.table_catalog    = 'kln'
--AND cols.table_name   = 'taxdoc'
AND cols.table_schema = 'public';





SELECT   *
FROM information_schema.columns
WHERE table_schema = 'public'
  --AND table_name   = 'taxdoc';
  
  
  select obj_description('public.patent.patent_id'::regclass, 'pg_class');
  
  
  select * from pg_description pg  limit 100;
  



SELECT
 *
FROM
 pg_catalog.pg_tables
WHERE
 schemaname = 'public';
 
SELECT * 
FROM pg_catalog.pg_statio_all_tables 
as st
inner join pg_catalog.pg_description pgd on (pgd.objoid=st.relid)
inner join information_schema.columns c on (pgd.objsubid=c.ordinal_position
and  c.table_schema=st.schemaname and c.table_name=st.relname)

where schemaname = 'public'
 limit 100;
 
 
 SELECT   cc.table_name, cc.column_name, pgd.description
FROM information_schema.columns  cc 
join pg_catalog.pg_description pgd on pgd.objsubid=cc.ordinal_position
join pg_catalog.pg_statio_all_tables  st on (pgd.objoid=st.relid)
where cc.table_schema = 'public'
limit 100 
 



--column comments for tables in public
select * from (
SELECT
    
    cols.*,
    (
        SELECT
            pg_catalog.col_description(c.oid, cols.ordinal_position::int)
        FROM
            pg_catalog.pg_class c
        WHERE
            c.oid = (SELECT ('"' || cols.table_name || '"')::regclass::oid)
            AND c.relname = cols.table_name
    ) AS column_comment
FROM
    information_schema.columns cols
WHERE
    cols.table_catalog    = 'kln'
    --AND cols.table_name   = 'taxdoc'
    AND cols.table_schema = 'public') as foo
    join decode  d on foo.column_name = lower(d.columnname)
    order by foo.table_name, foo.column_name;
    
    
---decode for columns
select foo.table_schema, foo.table_name, foo.column_name, array_agg(d.code || '-' || d.value ) seloptions,
foo.table_schema || '.'||  foo.table_name || '.'|| foo.column_name  colkey
   from (
SELECT
    
    cols.table_schema,
    cols.table_name,
    cols.column_name,
    (
        SELECT
            pg_catalog.col_description(c.oid, cols.ordinal_position::int)
        FROM
            pg_catalog.pg_class c
        WHERE
            c.oid = (SELECT ('"' || cols.table_name || '"')::regclass::oid)
            AND c.relname = cols.table_name
    ) AS column_comment
FROM
    information_schema.columns cols
WHERE
    cols.table_catalog    = 'kln'
    --AND cols.table_name   = 'taxdoc'
    AND cols.table_schema = 'public') as foo
    join decode  d on foo.column_name = lower(d.columnname)
     group by  foo.table_schema, foo.table_name, foo.column_name  order by foo.column_name, foo.table_name, foo.column_name;
	 
	 
 