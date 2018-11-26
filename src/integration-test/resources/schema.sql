SET DATABASE TRANSACTION CONTROL mvcc;

CREATE SCHEMA zeus_app_user;

DROP TABLE if EXISTS geo_ip_location_group_geo_ip_locations;
DROP TABLE IF EXISTS geo_ip_location_group;
DROP TABLE if EXISTS geo_ip_location;
DROP TABLE if EXISTS demographic_age;
DROP TABLE if EXISTS demographic_gender;
DROP TABLE if EXISTS demographic_language;
DROP TABLE if EXISTS demographic_race;

create table geo_ip_location_group (
id binary(255) not null,
enabled boolean not null,
geo_ip_location_group_type varchar(255),
group_expression varchar(255),
group_level1name varchar(255),
group_level2name varchar(255),
group_level3name varchar(255),
group_level4name varchar(255),
last_viewed_before_change timestamp,
primary key (id)
);

create table geo_ip_location_group_geo_ip_locations (
geo_ip_location_group_id binary(255) not null,
geo_ip_location_id binary(255) not null,
primary key (geo_ip_location_group_id, geo_ip_location_id)
);

create table geo_ip_location (
id binary(255) not null,
city varchar(255),
country_code varchar(255),
country_name varchar(255),
network varchar(255),
proxy boolean not null,
region varchar(255),
time_zone varchar(255),
primary key (id)
);

create table demographic_age (
id binary(255) not null,
display_name varchar(255),
value varchar(255),
primary key (id)
);

create table demographic_gender (
id binary(255) not null,
display_name varchar(255),
value varchar(255),
primary key (id)
)

create table demographic_language (
id binary(255) not null,
display_name varchar(255),
value varchar(255),
primary key (id)
);

create table demographic_race (
id binary(255) not null,
display_name varchar(255),
value varchar(255),
primary key (id)
);

create table zeus_users (
  id binary(255) not null,
  account_type varchar(255) not null,
  agency_address varchar(255),
  agency_contact_number varchar(255),
  agency_name varchar(255),
  billing_account_name varchar(255),
  billing_account_no varchar(255),
  billing_branch varchar(255),
  billing_branch_code varchar(255),
  billing_method varchar(255),
  billing_name varchar(255),
  contact_number_cellphone varchar(255) not null,
  contact_number_landline varchar(255),
  country varchar(255) not null,
  email_address varchar(255) not null,
  name varchar(255) not null,
  password varchar(255) not null,
  skype_name varchar(255),
  surname varchar(255) not null,
  username varchar(255) not null,
   primary key (id)
   );

create table advert (id binary(255) not null, advert_name varchar(255) not null, advert_text clob(255) not null, approval_state integer, banner_height integer, banner_image_id varchar(255), banner_width integer, deleted_at timestamp, force_click_through_rate numeric(19,2), force_click_through_rate_last_reset timestamp, mode varchar(255), paused boolean not null, type varchar(255), url clob(255) not null, campaign_id binary(255) not null, primary key (id))
create table advert_category (id binary(255) not null, category_name varchar(255), primary key (id))
create table advertiser (id binary(255) not null, address varchar(255) not null, advertiser_name varchar(255) not null, company_name varchar(255) not null, contact_number varchar(255) not null, country varchar(255) not null, include_cpa_code boolean, pollen8user_id binary(255) not null, primary key (id))
create table campaign (id binary(255) not null, add_internal_tracking_to_redirect_url boolean not null, approval_state varchar(255), automatically_pause_at timestamp, campaign_name varchar(255) not null, commission_external numeric(19,2), commission_internal numeric(19,2), cost_per_acquisition numeric(19,2), cost_per_click numeric(19,2), cost_per_download numeric(19,2), cost_per_mille numeric(19,2), currency_code varchar(255) not null, daily_spend_cap numeric(19,2), daily_spend_last_reset timestamp, deleted_at timestamp, end_date timestamp, end_hour integer check (end_hour>=0 AND end_hour<=23), landing_prefered_acquisition_code_key varchar(255), max_force_click_through_rate numeric(19,2), min_force_click_through_rate numeric(19,2), notes clob(255), partner boolean not null, paused boolean not null, remaining_budget numeric(19,2), remaining_daily_spend numeric(19,2), start_date timestamp, start_hour integer check (start_hour>=0 AND start_hour<=23), time_zone varchar(255) not null, unique_user_per_clicked_advert_required boolean not null, advertiser_id binary(255) not null, campaign_filter_id binary(255), category_id binary(255) not null, primary key (id))
create table campaign_run_on_days_of_the_week (campaign_id binary(255) not null, run_on_days_of_the_week varchar(255))
create table external_publisher (id binary(255) not null, accounts clob(255), country_and_networks_default clob(255), country_and_networks_options clob(255), daily_cap_default numeric(19,2), module_name varchar(255) not null, name varchar(255) not null, primary key (id))
create table external_publisher_site (id binary(255) not null, country_and_networks clob(255), daily_spend_cap numeric(19,2) not null, external_publisher_id binary(255), primary key (id))
create table filter_campaign (id binary(255) not null, allow_bypassing_proxies boolean not null, filter_out_geo_locations boolean not null, filter_out_handsets boolean not null, ip_targeting_ranges longvarchar, primary key (id))
create table filter_campaign_demographic_ages (campaign_filter_id binary(255) not null, demographic_id binary(255) not null, primary key (campaign_filter_id, demographic_id))
create table filter_campaign_demographic_genders (campaign_filter_id binary(255) not null, demographic_id binary(255) not null, primary key (campaign_filter_id, demographic_id))
create table filter_campaign_demographic_languages (campaign_filter_id binary(255) not null, demographic_id binary(255) not null, primary key (campaign_filter_id, demographic_id))
create table filter_campaign_demographic_races (campaign_filter_id binary(255) not null, demographic_id binary(255) not null, primary key (campaign_filter_id, demographic_id))
create table filter_campaign_demographic_sexual_preferences (campaign_filter_id binary(255) not null, demographic_id binary(255) not null, primary key (campaign_filter_id, demographic_id))
create table filter_campaign_geo_ip_location_groups (campaign_filter_id binary(255) not null, geo_ip_location_group_id binary(255) not null, primary key (campaign_filter_id, geo_ip_location_group_id))
create table filter_campaign_handset_groups (campaign_filter_id binary(255) not null, handset_group_id binary(255) not null, primary key (campaign_filter_id, handset_group_id))
create table handset (id binary(255) not null, brand_name varchar(255), marketing_name varchar(255), model_name varchar(255), os varchar(255), source_id varchar(255), version varchar(255), primary key (id))
create table handset_detail (id binary(255) not null, brand_name varchar(255), browser_name varchar(255), browser_version varchar(255), can_assign_phone_number boolean not null, make_phone_call_string varchar(255), make_phone_sms_string varchar(255), marketing_name varchar(255), model_name varchar(255), os varchar(255), source_id varchar(255), tablet boolean not null, user_agent longvarchar, version varchar(255), wifi boolean not null, wireless_device boolean not null, primary key (id))
create table handset_group (id binary(255) not null, enabled boolean not null, group_expression varchar(255), group_level1name varchar(255), group_level2name varchar(255), group_level3name varchar(255), group_level4name varchar(255), group_type varchar(255), last_viewed_before_change timestamp, primary key (id))
create table handset_group_handsets (handset_group_id binary(255) not null, handset_id binary(255) not null, primary key (handset_group_id, handset_id))
create table placement (id binary(255) not null, rev_share_override numeric(19,2) check (rev_share_override<=100 AND rev_share_override>=0), weight integer not null, campaign_id binary(255) not null, publisher_site_id binary(255) not null, primary key (id))
create table publisher (id binary(255) not null, contact_email varchar(255) not null, contact_number varchar(255) not null, deleted_at timestamp, notes clob(255), publisher_name varchar(255) not null, external_publisher_id binary(255), pollen8user_id binary(255) not null, primary key (id))
create table publisher_site (id binary(255) not null, approval_state varchar(255), deleted_at timestamp, last_request_received timestamp, notes clob(255), paused boolean not null, revenue_share_percentage numeric(19,2) check (revenue_share_percentage<=100 AND revenue_share_percentage>=0), send_net_cpc boolean not null, shows_banners boolean not null, shows_rich_media boolean not null, shows_text boolean not null, site_name varchar(255) not null, url clob(255) not null, external_publisher_site_id binary(255), publisher_id binary(255) not null, primary key (id))
create table publisher_sites_scheduled_advert_categories (publisher_site_id binary(255) not null, scheduled_advert_category_id binary(255) not null)
create table scheduled_advert_categories (id binary(255) not null, end_at integer check (end_at>=0 AND end_at<=23), start_at integer check (start_at>=0 AND start_at<=23), advert_category_id binary(255), primary key (id))
create table tracking_target (id binary(255) not null, priority numeric(19,2), advert_id binary(255) not null, publisher_site_id binary(255) not null, primary key (id))
create table tracking_target_statistics (id binary(255) not null, date_utc date, hour_utc TINYINT NOT NULL, acquisitions bigint not null, clicks bigint not null, commission_external numeric(16,4), commission_internal numeric(16,4), downloads bigint not null, impressions numeric(16,4), publisher_revenue numeric(16,4), real_impressions bigint not null, spend numeric(16,4), tracking_target_id binary(255) not null, primary key (id))

COMMIT ;

