resource "aws_s3_bucket" "bucket" {
  bucket = "space.codesoom.com"

  acl = "public-read"

  website {
    index_document = "index.html"
    error_document = "index.html"
  }

  tags = local.tags
}
