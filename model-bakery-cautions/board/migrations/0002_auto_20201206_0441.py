# Generated by Django 3.1.4 on 2020-12-06 04:41

import board.models
from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('board', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='board',
            name='content',
            field=board.models.ContentField(max_length=100),
        ),
        migrations.AlterField(
            model_name='reply',
            name='content',
            field=board.models.ContentField(max_length=100),
        ),
    ]