# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

from odoo import models, fields, api

class sponsor(models.Model):
    _name = 'ofc_odoo.sponsor'
    
    name = fields.Char(required = True)
    email = fields.Char(required = True)
    state = fields.Boolean()
    date = fields.Datetime(required = True)
    phone = fields.Integer(required = True)
    events = fields.Many2Many('ofc_odoo.event', string ="Events")
    admin = fields.Many2One('res.Users', string ="Admin", required = True)
    
